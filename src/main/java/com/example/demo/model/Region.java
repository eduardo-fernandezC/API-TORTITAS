package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_region;

    @Column(nullable = false, length = 100)
    private String nombre_region;

    @OneToMany(mappedBy = "region")
    private List<Comuna> comunas;
}

