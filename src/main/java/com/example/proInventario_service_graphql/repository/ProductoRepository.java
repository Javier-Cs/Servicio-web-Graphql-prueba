package com.example.proInventario_service_graphql.repository;

import com.example.proInventario_service_graphql.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
