package com.example.proInventario_service_graphql.dto;

public record ProductNewDto(
        int id,
        String nombre,
        double precio,
        int cantidad,
        int categoriaId
) {
}
