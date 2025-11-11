package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(nullable = false, length = 40)
    private String nombre;

    // Relación: Un Rol tiene muchos Usuarios
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}
