package com.example.proInventario_service_graphql.dto;

public record ProductDto(
        String nombre,
        double precio,
        int cantidad,
        int categoriaId
) {
}
