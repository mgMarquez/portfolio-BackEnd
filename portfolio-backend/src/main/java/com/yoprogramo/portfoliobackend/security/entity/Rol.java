package com.yoprogramo.portfoliobackend.security.entity;

import com.sun.istack.NotNull;
import com.yoprogramo.portfoliobackend.security.enums.RolTipo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RolTipo rolTipo;
}
