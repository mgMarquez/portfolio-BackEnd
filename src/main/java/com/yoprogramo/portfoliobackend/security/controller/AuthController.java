package com.yoprogramo.portfoliobackend.security.controller;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;
import com.yoprogramo.portfoliobackend.model.Usuario;
import com.yoprogramo.portfoliobackend.security.dto.JwtDTO;
import com.yoprogramo.portfoliobackend.security.dto.LoginUsuario;
import com.yoprogramo.portfoliobackend.security.entity.Rol;
import com.yoprogramo.portfoliobackend.security.enums.RolTipo;
import com.yoprogramo.portfoliobackend.security.jwt.JwtProvider;
import com.yoprogramo.portfoliobackend.security.service.IRolService;
import com.yoprogramo.portfoliobackend.security.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IRolService rolService;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/roles")
    public List<Rol> mostrarRoles() {
        return rolService.mostrarRoles();
    }
    @PostMapping("/roles/nuevo")
    public void nuevoRol(@RequestBody Rol rol) {
        rolService.save(rol);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody UsuarioDTO nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Campos mal puestos o email invalido", HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombre()))
            return new ResponseEntity<>("Ese nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity<>("Ese email ya existe", HttpStatus.BAD_REQUEST);

        Usuario usuario = new Usuario();
        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setEmail(nuevoUsuario.getEmail());
        String password = passwordEncoder.encode(nuevoUsuario.getContrasenia());
        usuario.setContrasenia(password);

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolTipo.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolTipo.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity<>("Usuario guardado", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        if (bindingResult.hasErrors())
//            return new ResponseEntity("Campos mal puestos", HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreUsuario(),
                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity<>(jwtDTO, HttpStatus.OK);
    }
}
