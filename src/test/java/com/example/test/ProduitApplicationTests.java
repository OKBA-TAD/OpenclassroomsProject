package com.example.test;

//import static org.junit.jupiter.api.Assertions.*;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.controller.*;
import com.example.dao.ProduitRepository;
import com.example.model.Produit;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration
//@WebMvcTest(controllers=ProduitController.class)
//@AutoConfigureMockMvc
@SpringBootTest(classes= {ProduitController.class, ProduitNotFoundException.class, ProduitNotFoundAdvice.class, ProduitRepository.class, Produit.class} )
@EnableJpaRepositories("com.example.dao")
@EntityScan("com.example.model")
@ComponentScan("com.example.controller")
class ProduitApplicationTests {

	@Autowired
	ProduitController produitController;
	 
	@Test
	public void contextLoads() {
		Assertions.assertThat(produitController).isNot(null);
	}
	
	/*@Autowired
	private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {
        ResponseEntity<Produit> response = template.getForEntity("/demo/produit/2", Produit.class);
        Assertions.assertThat(response.getBody().getNom()).isEqualTo("Chocolat");
    }*/

}
