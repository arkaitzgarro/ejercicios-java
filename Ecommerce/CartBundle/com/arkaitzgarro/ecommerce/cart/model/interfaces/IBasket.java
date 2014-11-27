package com.arkaitzgarro.ecommerce.cart.model.interfaces;

import java.util.ArrayList;

public interface IBasket {

	/**
	 * Get all lines
	 * 
	 * @return
	 */
	public abstract ArrayList<ILine> getLines();

	/**
	 * Get cart total ammount, with VAT
	 * 
	 * @return
	 */
	public abstract float getTotalWithVAT();

	/**
	 * Get cart total ammount, without VAT
	 * 
	 * @return
	 */
	public abstract float getTotalWithoutVAT();

	/**
	 * Get number of lines
	 * 
	 * @return
	 */
	public abstract int getNumLines();

	/**
	 * Get total number of products
	 * 
	 * @return
	 */
	public abstract int getNumProducts();

}