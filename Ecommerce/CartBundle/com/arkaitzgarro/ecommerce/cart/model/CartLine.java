package com.arkaitzgarro.ecommerce.cart.model;

import com.arkaitzgarro.ecommerce.cart.model.abstracts.AbstractLine;
import com.arkaitzgarro.ecommerce.catalog.model.Product;

public class CartLine extends AbstractLine {

	/**
	 * My cart
	 */
	private Cart cart;

	public CartLine(Product p, int quantity, Cart cart) {
		super(p, quantity);

		this.setCart(cart);
	}

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart
	 *            the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
