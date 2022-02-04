package com.example.demo1;

import com.example.demo1.interfaces.IProductRepository;
import com.example.demo1.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	public CommandLineRunner runProducts (IProductRepository productRepository) {
		return (args -> {
			insertProducts(productRepository);
			System.out.println(productRepository.findAll());
		});
	}

	public void insertProducts(IProductRepository productRepository) {
		productRepository.save(new Product("Żółw żółtolicy","zwierzę", 20,70));
		productRepository.save(new Product("Żółw grecki","zwierzę", 20,120));
		productRepository.save(new Product("Bojownik","zwierzę",20,30));
		productRepository.save(new Product("Karma dla żółwi","karma",420,10));
		productRepository.save(new Product("Karma dla rybek","karma",20,10));
		productRepository.save(new Product("Karma dla kotów","karma",20,10));
	}
}