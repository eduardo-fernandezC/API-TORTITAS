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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String contrasenia;

    @Column(nullable = false, length = 12)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    // Relación opcional con dirección principal
    @ManyToOne
    @JoinColumn(name = "id_direccion", nullable = true)
    private Direccion direccionPrincipal;

    // Un usuario puede tener varias direcciones
    @OneToMany(mappedBy = "usuario")
    private List<Direccion> direcciones;

    // Un usuario realiza muchos pedidos
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;
}
