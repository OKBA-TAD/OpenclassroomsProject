package com.example.model;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/*import lombok.Getter;
import lombok.Setter;*/

@Entity
/*@Getter
@Setter*/
@Table(name="products")
@XmlRootElement
public class Produit implements Serializable{
	@Id
	// identity == +1 a chaque fois Autoincrement
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	String nom;
	double price;
	double quantite;
	
	
	
	public Produit() {
		
	}
	
	public Produit( String nom, double price, double q) {
		this.nom=nom;
		this.price=price;
		this.quantite=q;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
}
