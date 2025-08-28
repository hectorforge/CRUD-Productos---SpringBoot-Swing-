package com.example.demo.seeder;

import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductSeeder {
	
	private final ProductRepository prepo;
	
	@PostConstruct
	void init() {
		if (prepo.count() == 0) {
			Product p1 = Product.builder().name("Laptop Lenovo").description("Laptop Lenovo IdeaPad 15.6” con Ryzen 5").price(2500).stock(10).activo(true).build();
			Product p2 = Product.builder().name("Smartphone Samsung").description("Samsung Galaxy S23 con 128GB").price(3200).stock(15).activo(true).build();
			Product p3 = Product.builder().name("Monitor LG 27''").description("Monitor LG UHD 4K").price(1200).stock(8).activo(true).build();
			Product p4 = Product.builder().name("Teclado Mecánico").description("Teclado mecánico Redragon RGB").price(250).stock(20).activo(true).build();
			Product p5 = Product.builder().name("Mouse Gamer").description("Mouse Logitech G502 HERO").price(180).stock(25).activo(true).build();
			Product p6 = Product.builder().name("Impresora HP").description("Impresora multifuncional HP DeskJet").price(450).stock(12).activo(true).build();
			Product p7 = Product.builder().name("Auriculares Sony").description("Auriculares Sony WH-1000XM5").price(1300).stock(9).activo(true).build();
			Product p8 = Product.builder().name("Tablet Apple iPad").description("iPad 10th Gen 64GB").price(2200).stock(7).activo(true).build();
			Product p9 = Product.builder().name("Disco SSD 1TB").description("Samsung SSD 1TB NVMe").price(600).stock(30).activo(true).build();
			Product p10 = Product.builder().name("Silla Gamer").description("Silla ergonómica reclinable con soporte lumbar").price(900).stock(5).activo(true).build();

			prepo.save(p1);
			prepo.save(p2);
			prepo.save(p3);
			prepo.save(p4);
			prepo.save(p5);
			prepo.save(p6);
			prepo.save(p7);
			prepo.save(p8);
			prepo.save(p9);
			prepo.save(p10);
		}
	}
}
