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

			Product p11 = Product.builder().name("Cámara Canon").description("Cámara Canon EOS Rebel T7i").price(2800).stock(6).activo(true).build();
			Product p12 = Product.builder().name("Router TP-Link").description("Router inalámbrico Archer AX50 Wi-Fi 6").price(350).stock(15).activo(true).build();
			Product p13 = Product.builder().name("Disco Duro Externo 2TB").description("WD Elements 2TB USB 3.0").price(450).stock(18).activo(true).build();
			Product p14 = Product.builder().name("Parlantes Bose").description("Bose SoundLink Revolve+ Bluetooth").price(1600).stock(4).activo(true).build();
			Product p15 = Product.builder().name("Proyector Epson").description("Proyector Epson Full HD 1080p").price(3200).stock(3).activo(true).build();
			Product p16 = Product.builder().name("Consola PlayStation 5").description("Sony PlayStation 5 Digital Edition").price(4200).stock(10).activo(true).build();
			Product p17 = Product.builder().name("Consola Xbox Series X").description("Microsoft Xbox Series X 1TB").price(4000).stock(7).activo(true).build();
			Product p18 = Product.builder().name("Nintendo Switch OLED").description("Nintendo Switch OLED Model 64GB").price(2500).stock(12).activo(true).build();
			Product p19 = Product.builder().name("Kindle Paperwhite").description("Amazon Kindle Paperwhite 11th Gen").price(700).stock(20).activo(true).build();
			Product p20 = Product.builder().name("GoPro Hero 11").description("GoPro Hero 11 Black 5.3K").price(2100).stock(5).activo(true).build();

			Product p21 = Product.builder().name("Laptop Dell XPS").description("Dell XPS 13 con Intel i7 12th Gen").price(4800).stock(6).activo(true).build();
			Product p22 = Product.builder().name("Laptop HP Omen").description("HP Omen Gaming Ryzen 7 RTX 3060").price(5200).stock(4).activo(true).build();
			Product p23 = Product.builder().name("Smartwatch Apple Watch").description("Apple Watch Series 8 GPS").price(1800).stock(9).activo(true).build();
			Product p24 = Product.builder().name("Smartwatch Samsung Galaxy Watch").description("Samsung Galaxy Watch5 Pro").price(1500).stock(11).activo(true).build();
			Product p25 = Product.builder().name("Smart TV Samsung 55''").description("Samsung QLED 4K HDR 55 pulgadas").price(3300).stock(7).activo(true).build();
			Product p26 = Product.builder().name("Smart TV LG 65''").description("LG OLED C2 65 pulgadas 4K HDR").price(6200).stock(4).activo(true).build();
			Product p27 = Product.builder().name("Smart TV Sony 75''").description("Sony Bravia 75 pulgadas 8K HDR").price(11000).stock(2).activo(true).build();
			Product p28 = Product.builder().name("Barra de Sonido JBL").description("Barra de sonido JBL 5.1 Dolby Atmos").price(1900).stock(8).activo(true).build();
			Product p29 = Product.builder().name("Tablet Samsung Galaxy Tab").description("Samsung Galaxy Tab S8 Ultra").price(2900).stock(6).activo(true).build();
			Product p30 = Product.builder().name("Tablet Xiaomi Pad 5").description("Xiaomi Pad 5 Pro 256GB").price(1800).stock(10).activo(true).build();

			Product p31 = Product.builder().name("Laptop MacBook Air").description("Apple MacBook Air M2 13 pulgadas").price(5600).stock(5).activo(true).build();
			Product p32 = Product.builder().name("Laptop MacBook Pro").description("Apple MacBook Pro 14 pulgadas M2 Pro").price(8800).stock(4).activo(true).build();
			Product p33 = Product.builder().name("Auriculares Beats").description("Beats Studio3 Wireless Noise Cancelling").price(1200).stock(8).activo(true).build();
			Product p34 = Product.builder().name("Auriculares Razer Kraken").description("Razer Kraken Gaming Headset").price(500).stock(15).activo(true).build();
			Product p35 = Product.builder().name("Microfono Blue Yeti").description("Blue Yeti USB Mic para streaming").price(700).stock(12).activo(true).build();
			Product p36 = Product.builder().name("Cámara Logitech").description("Logitech Brio 4K Webcam HDR").price(950).stock(10).activo(true).build();
			Product p37 = Product.builder().name("Tarjeta Gráfica NVIDIA RTX 4080").description("NVIDIA GeForce RTX 4080 16GB").price(8500).stock(3).activo(true).build();
			Product p38 = Product.builder().name("Tarjeta Gráfica AMD RX 7900").description("AMD Radeon RX 7900 XT 20GB").price(7500).stock(4).activo(true).build();
			Product p39 = Product.builder().name("Fuente de Poder Corsair 850W").description("Corsair RM850x 80 Plus Gold").price(750).stock(15).activo(true).build();
			Product p40 = Product.builder().name("Placa Madre ASUS ROG").description("ASUS ROG Strix X670E Gaming").price(2000).stock(6).activo(true).build();

			Product p41 = Product.builder().name("Memoria RAM Corsair 16GB").description("Corsair Vengeance DDR5 5600MHz").price(600).stock(20).activo(true).build();
			Product p42 = Product.builder().name("Memoria RAM Kingston 32GB").description("Kingston Fury Beast DDR5 6000MHz").price(1200).stock(12).activo(true).build();
			Product p43 = Product.builder().name("Cooler Líquido NZXT").description("NZXT Kraken X63 RGB").price(1100).stock(7).activo(true).build();
			Product p44 = Product.builder().name("Disipador Cooler Master").description("Cooler Master Hyper 212 Black Edition").price(350).stock(18).activo(true).build();
			Product p45 = Product.builder().name("Case Gamer NZXT").description("NZXT H510 Elite RGB ATX").price(900).stock(10).activo(true).build();
			Product p46 = Product.builder().name("Case Gamer Corsair").description("Corsair iCUE 5000X RGB ATX").price(1200).stock(6).activo(true).build();
			Product p47 = Product.builder().name("Volante Logitech G29").description("Logitech G29 Driving Force PS5/PC").price(2200).stock(5).activo(true).build();
			Product p48 = Product.builder().name("Joystick Xbox Elite").description("Xbox Elite Series 2 Controller").price(950).stock(9).activo(true).build();
			Product p49 = Product.builder().name("Joystick DualSense").description("Sony DualSense Wireless Controller PS5").price(420).stock(14).activo(true).build();
			Product p50 = Product.builder().name("Silla de Oficina Ergonómica").description("Silla ergonómica con soporte cervical").price(1100).stock(8).activo(true).build();

			Product p51 = Product.builder().name("Drone DJI Mini 3").description("DJI Mini 3 Pro 4K cámara 48MP").price(3400).stock(4).activo(true).build();
			Product p52 = Product.builder().name("Cámara Nikon Z6").description("Nikon Z6 II Full Frame Mirrorless").price(7200).stock(3).activo(true).build();
			Product p53 = Product.builder().name("Lente Canon 50mm").description("Canon EF 50mm f/1.8 STM").price(650).stock(10).activo(true).build();
			Product p54 = Product.builder().name("Tablet Lenovo M10").description("Lenovo M10 Plus 10.6 pulgadas").price(900).stock(12).activo(true).build();
			Product p55 = Product.builder().name("Impresora Epson EcoTank").description("Epson EcoTank L3250 multifuncional").price(800).stock(11).activo(true).build();
			Product p56 = Product.builder().name("Scanner Brother").description("Brother ADS-1700W Wi-Fi Scanner").price(1500).stock(5).activo(true).build();
			Product p57 = Product.builder().name("Smartphone Xiaomi 13").description("Xiaomi 13 Pro 256GB 12GB RAM").price(2800).stock(6).activo(true).build();
			Product p58 = Product.builder().name("Smartphone Motorola Edge").description("Motorola Edge 30 Ultra 256GB").price(2600).stock(8).activo(true).build();
			Product p59 = Product.builder().name("Bicicleta Eléctrica").description("Bicicleta eléctrica plegable urbana").price(4500).stock(3).activo(true).build();
			Product p60 = Product.builder().name("Patineta Eléctrica").description("Scooter eléctrico Xiaomi Pro 2").price(1800).stock(7).activo(true).build();

			prepo.save(p1); prepo.save(p2); prepo.save(p3); prepo.save(p4); prepo.save(p5);
			prepo.save(p6); prepo.save(p7); prepo.save(p8); prepo.save(p9); prepo.save(p10);
			prepo.save(p11); prepo.save(p12); prepo.save(p13); prepo.save(p14); prepo.save(p15);
			prepo.save(p16); prepo.save(p17); prepo.save(p18); prepo.save(p19); prepo.save(p20);
			prepo.save(p21); prepo.save(p22); prepo.save(p23); prepo.save(p24); prepo.save(p25);
			prepo.save(p26); prepo.save(p27); prepo.save(p28); prepo.save(p29); prepo.save(p30);
			prepo.save(p31); prepo.save(p32); prepo.save(p33); prepo.save(p34); prepo.save(p35);
			prepo.save(p36); prepo.save(p37); prepo.save(p38); prepo.save(p39); prepo.save(p40);
			prepo.save(p41); prepo.save(p42); prepo.save(p43); prepo.save(p44); prepo.save(p45);
			prepo.save(p46); prepo.save(p47); prepo.save(p48); prepo.save(p49); prepo.save(p50);
			prepo.save(p51); prepo.save(p52); prepo.save(p53); prepo.save(p54); prepo.save(p55);
			prepo.save(p56); prepo.save(p57); prepo.save(p58); prepo.save(p59); prepo.save(p60);
		}
	}
}