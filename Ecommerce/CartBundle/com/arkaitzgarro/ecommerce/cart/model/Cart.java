package com.arkaitzgarro.ecommerce.cart.model;

import com.arkaitzgarro.ecommerce.cart.model.abstracts.AbstractBasket;
import com.arkaitzgarro.ecommerce.cart.model.interfaces.IBasket;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IProduct;

public class Cart extends AbstractBasket implements IBasket {

	public Cart() {
		super();
	}

	/**
	 * Add a new product to the cart. If exists, update the quantity
	 * 
	 * @param p
	 * @param quantity
	 */
	public void addProduct(IProduct p, int quantity) {
		CartLine cl = (CartLine) findAbstractLine(p);

		if (cl == null) {
			getLines().add(new CartLine(p, quantity, this));

		} else {
			updateQuantity(cl, quantity);
		}
	}

	/**
	 * Update the quantity of a product
	 * 
	 * @param p
	 * @param quantity
	 */
	public void updateQuantity(IProduct p, int quantity) {
		CartLine cl = (CartLine) findAbstractLine(p);

		if (cl != null) {
			updateQuantity(cl, quantity);
		} else {
			// TODO: throws an exception
		}
	}

	/**
	 * Update product quantity
	 * 
	 * @param cartLine
	 * @param quantity
	 */
	private void updateQuantity(CartLine cartLine, int quantity) {
		// If quantity <= 0, it remains to 1
		cartLine.setQuantity(quantity);
	}

	/**
	 * Remove the given product. Nothing happens if not exists in the cart
	 * 
	 * @param p
	 */
	public void removeProduct(IProduct p) {
		getLines().remove((CartLine) findAbstractLine(p));
	}

	/**
	 * Empty all cart lines
	 */
	public void empty() {
		getLines().clear();
	}
}
