package com.youcode.MonSupplier.models.Entities;

import com.youcode.MonSupplier.models.Enums.RoleUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String Nom;
    private String Prenom;
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;
    private Boolean isVerifie;
}