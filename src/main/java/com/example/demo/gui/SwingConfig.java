package com.example.demo.gui;

import javax.swing.SwingUtilities;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@Configuration
public class SwingConfig {

	@Bean
	public HomeFrm homeFrm(ProductService ps) {
		HomeFrm h = new HomeFrm(ps);
		h.setVisible(true);
		return h;
	}
}
