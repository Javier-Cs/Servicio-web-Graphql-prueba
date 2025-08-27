package com.example.proInventario_service_graphql.controllersWeb;

import com.example.proInventario_service_graphql.entities.Producto;
import com.example.proInventario_service_graphql.repository.ProductoRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductControllerWeb {

    private ProductoRepository productoRepository;

    public ProductControllerWeb(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @QueryMapping
    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
}
