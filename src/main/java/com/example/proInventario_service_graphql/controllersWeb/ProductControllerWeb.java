package com.example.proInventario_service_graphql.controllersWeb;

import com.example.proInventario_service_graphql.entities.Categoria;
import com.example.proInventario_service_graphql.entities.Producto;
import com.example.proInventario_service_graphql.repository.CategoriaRepository;
import com.example.proInventario_service_graphql.repository.ProductoRepository;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ProductControllerWeb {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductControllerWeb(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @QueryMapping
    public List<Producto> listarProductos(){
        return productoRepository.findAll();

    }

    @QueryMapping
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

}
