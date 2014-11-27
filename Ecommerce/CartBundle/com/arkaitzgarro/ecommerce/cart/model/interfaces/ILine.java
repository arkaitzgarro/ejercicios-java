package com.arkaitzgarro.ecommerce.cart.model.interfaces;

import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IPurchasable;

public interface ILine {

	/**
	 * @return the product
	 */
	public IPurchasable getProduct();

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(IPurchasable product);

	/**
	 * @return the quantity
	 */
	public int getQuantity();

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity);

	/**
	 * Get total with VAT included
	 * 
	 * @return
	 */
	public float getTotalWithVAT();

	/**
	 * Get total without VAT
	 * 
	 * @return
	 */
	public float getTotalWithoutVAT();

}