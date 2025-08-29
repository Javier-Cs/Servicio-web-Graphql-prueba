package com.example.proInventario_service_graphql.controllersWeb;

import com.example.proInventario_service_graphql.dto.ProductDto;
import com.example.proInventario_service_graphql.dto.ProductNewDto;
import com.example.proInventario_service_graphql.entities.Categoria;
import com.example.proInventario_service_graphql.entities.Producto;
import com.example.proInventario_service_graphql.repository.CategoriaRepository;
import com.example.proInventario_service_graphql.repository.ProductoRepository;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @QueryMapping
    public Producto listarById(@Argument int id){
        return productoRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Producto not found with id " + id))
        );
    }

    @MutationMapping
    public Producto guardarProducto(@Argument ProductDto productoDto){
        Categoria  categoria = categoriaRepository.findById(productoDto.categoriaId()).orElse(null);
        Producto productoDb = new  Producto();
        productoDb.setNombre(productoDto.nombre());
        productoDb.setPrecio(productoDto.precio());
        productoDb.setCantidad(productoDto.cantidad());
        productoDb.setCategoria(categoria);
        return productoRepository.save(productoDb);
    }

    @MutationMapping
    public Producto actualizarProducto(@Argument ProductNewDto productNewDto){
        Categoria categoria = categoriaRepository.findById(productNewDto.categoriaId()).orElse(null);
        Producto productNew = new  Producto();
        productNew.setId(productNewDto.id());
        productNew.setNombre(productNewDto.nombre());
        productNew.setPrecio(productNewDto.precio());
        productNew.setCantidad(productNewDto.cantidad());
        productNew.setCategoria(categoria);
        return productoRepository.save(productNew);
    }

    @MutationMapping
    public void eliminarProducto(@Argument int id){
        productoRepository.deleteById(id);
    }
}
