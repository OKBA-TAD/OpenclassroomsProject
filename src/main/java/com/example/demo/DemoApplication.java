package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import com.example.dao.ProduitRepository;
//import com.example.model.Produit;

@SpringBootApplication
@EnableJpaRepositories("com.example.dao")
@EntityScan("com.example.model")
@ComponentScan("com.example.controller")
@Configuration("com.example.config")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	

	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}*/
	
	/*@Bean
	CommandLineRunner start(ProduitRepository produitRepo) {
		return args -> {
			produitRepo.save(new Produit("Biere", 255, 65 ));
			produitRepo.save(new Produit("alcool", 400, 3 ));
		};
		
	}*/

}
