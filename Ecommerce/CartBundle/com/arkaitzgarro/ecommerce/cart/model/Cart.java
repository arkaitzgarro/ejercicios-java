package com.arkaitzgarro.ecommerce.cart.model;

import java.util.ArrayList;

import com.arkaitzgarro.ecommerce.catalog.model.Product;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Cart extends AbstractEntity {
	private ArrayList<CartLine> lines;

	public Cart() {
		lines = new ArrayList<CartLine>();
	}

	/**
	 * Add a new product to the cart. If exists, update the quantity
	 * 
	 * @param p
	 * @param quantity
	 */
	public void addProduct(Product p, int quantity) {
		CartLine cl = findCartLine(p);

		if (cl == null) {
			lines.add(new CartLine(p, quantity));
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
	public void updateQuantity(Product p, int quantity) {
		CartLine cl = findCartLine(p);

		if (cl != null) {
			updateQuantity(cl, quantity);
		} else {
			// TODO: throws an exception
		}
	}

	private void updateQuantity(CartLine cartLine, int quantity) {
		// If quantity <= 0, it remains to 1
		cartLine.setQuantity(quantity);
	}

	/**
	 * Get cart total ammount, with VAT
	 * 
	 * @return
	 */
	public float getTotalWithVAT() {
		float total = 0;

		for (CartLine cartLine : lines) {
			total = cartLine.getTotalWithVAT();
		}

		return total;
	}

	/**
	 * Get cart total ammount, without VAT
	 * 
	 * @return
	 */
	public float getTotalWithoutVAT() {
		float total = 0;

		for (CartLine cartLine : lines) {
			total = cartLine.getTotalWithoutVAT();
		}

		return total;
	}

	/**
	 * Remove the given product. Nothing happens if not exists in the cart
	 * 
	 * @param p
	 */
	public void removeProduct(Product p) {
		lines.remove(findCartLine(p));
	}

	/**
	 * Empty all cart lines
	 */
	public void empty() {
		lines.clear();
	}

	/**
	 * Find a CartLine for the given product. Return null if not exist
	 * 
	 * @param p
	 * @return
	 */
	private CartLine findCartLine(Product p) {
		for (CartLine cartLine : lines) {
			if (cartLine.getProduct().equals(p)) {
				return cartLine;
			}
		}

		return null;
	}

	/**
	 * Get number of lines
	 * 
	 * @return
	 */
	public int getNumLines() {
		return this.lines.size();
	}

	/**
	 * Get total number of products
	 * 
	 * @return
	 */
	public int getNumProducts() {
		int total = 0;

		for (CartLine cartLine : lines) {
			total += cartLine.getQuantity();
		}

		return total;
	}
}
