package com.arkaitzgarro.ecommerce.cart.model;

import com.arkaitzgarro.ecommerce.cart.model.abstracts.AbstractLine;
import com.arkaitzgarro.ecommerce.cart.model.interfaces.ILine;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IProduct;

public class CartLine extends AbstractLine implements ILine {

	/**
	 * My cart
	 */
	private Cart cart;

	public CartLine(IProduct p, int quantity, Cart cart) {
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
