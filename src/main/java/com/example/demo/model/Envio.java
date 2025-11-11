package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_envio;

    @Column(nullable = false, length = 255)
    private String direccion_envio;

    private LocalDateTime fecha_envio;

    @Column(nullable = false, length = 30)
    private String estado_envio;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    @OneToOne(mappedBy = "envio")
    private Pedido pedido;
}
