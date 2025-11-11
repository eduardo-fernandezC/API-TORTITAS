package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sabor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sabor;

    @Column(nullable = false, length = 100)
    private String nombre_sabor;

    @OneToMany(mappedBy = "sabor")
    private List<Producto> productos;
}
