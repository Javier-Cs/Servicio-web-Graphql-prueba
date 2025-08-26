package com.example.proInventario_service_graphql.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Producto", schema = "PGraphql")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pro_id")
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Categoria_id", nullable = false)
    private Categoria categoria;

}
