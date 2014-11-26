package com.arkaitzgarro.ecommerce.cart.model;

import com.arkaitzgarro.ecommerce.cart.model.abstracts.AbstractLine;
import com.arkaitzgarro.ecommerce.catalog.model.Product;

public class CartLine extends AbstractLine {

	public CartLine(Product p, int quantity) {
		super(p, quantity);
	}

}
