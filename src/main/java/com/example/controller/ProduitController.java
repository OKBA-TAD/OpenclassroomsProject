package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.dao.ProduitRepository;
//import com.example.dao.ProduitRepositoryImp;
import com.example.model.Produit;


@RestController
@RequestMapping(path="/demo")
public class ProduitController {
	
	
	@Autowired
	private final ProduitRepository produitRepo;
	
	public ProduitController(){
		this.produitRepo = null;
	}
	
	public ProduitController(ProduitRepository produitRepo) {
        this.produitRepo = produitRepo;
    }
	
	@PostMapping(path="/produit/add")
	public void createProduit(@RequestBody Produit p) {
		this.produitRepo.save(p);
	}
	
	@GetMapping(path="/produit/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Produit getById(@PathVariable int id) {
		return this.produitRepo.findById(id)
				.orElseThrow(() -> new ProduitNotFoundException(id));
	}
	
	@GetMapping(path="/produits", produces= {MediaType.APPLICATION_XML_VALUE})
	public List<Produit> getAllProduit() {
		return this.produitRepo.findAll();
	}
	
	@PutMapping("/updateProduit/{id}")
	Produit replaceProduit(@RequestBody Produit newProduct, @PathVariable int id) {
	    
	    return this.produitRepo.findById(id)
	      .map(produit -> {
	        produit.setNom(newProduct.getNom());
	        produit.setPrice(newProduct.getPrice());
	        return this.produitRepo.save(produit);
	      })
	      .orElseGet(() -> {
	    	  newProduct.setId(id);
	    	  return this.produitRepo.save(newProduct);
	      });
	  }
	
	@DeleteMapping(path="/removeProduit/{id}")
	public void removeProduit(@PathVariable int id) {
		this.produitRepo.deleteById(id);
	}
	
	

}
