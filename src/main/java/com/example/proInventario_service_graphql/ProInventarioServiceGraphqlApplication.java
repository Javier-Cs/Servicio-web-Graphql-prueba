package com.example.proInventario_service_graphql;

import com.example.proInventario_service_graphql.entities.Categoria;
import com.example.proInventario_service_graphql.entities.Producto;
import com.example.proInventario_service_graphql.repository.CategoriaRepository;
import com.example.proInventario_service_graphql.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class ProInventarioServiceGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProInventarioServiceGraphqlApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (CategoriaRepository categoriaRepository, ProductoRepository productoRepository) {
		Random random = new Random();

		return  args -> {
			List.of("Computadores", "Telefonos", "Monitores", "Mouses").forEach(cat -> {
				Categoria categoria = Categoria.builder().nombre(cat).build();
				categoriaRepository.save(categoria);
			});

			categoriaRepository.findAll().forEach( categoria -> {
				for (int i = 0; i < 10; i++) {
					Producto producto = Producto.builder()
							.nombre("Computadores"+i)
							.precio(100+ Math.random()*50000)
							.cantidad(random.nextInt(20))
							.categoria(categoria)
							.build();
					productoRepository.save(producto);
				}
			});

		};
	}

}
