package com.example.controller;

public class ProduitNotFoundException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ProduitNotFoundException(int id) {
		super("Could not find product " + id);
	}
}

