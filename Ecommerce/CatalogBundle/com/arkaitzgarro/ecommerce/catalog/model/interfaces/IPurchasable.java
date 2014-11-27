package com.arkaitzgarro.ecommerce.catalog.model.interfaces;

public interface IPurchasable {

	/**
	 * Get product name
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Set product name
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * Get brand
	 * 
	 * @return Get the brand
	 */
	public IBrand getBrand();

	/**
	 * @param brand
	 *            Set the brand for this product
	 */
	public void setBrand(IBrand brand);

	/**
	 * Get the price
	 * 
	 * @return
	 */
	public IMoney getPrice();

	/**
	 * @return the stock
	 */
	public int getStock();

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(int stock);

	/**
	 * Get the price without VAT
	 * 
	 * @return
	 */
	public IMoney getPriceWithoutVAT();

	/**
	 * Get the price with VAT
	 * 
	 * @return
	 */
	public IMoney getPriceWithVAT();

	/**
	 * Set money (ammount) for this price
	 * 
	 * @param price
	 *            Set the price for this product
	 */
	public void setPrice(float ammount);

	/**
	 * Set the price for this product
	 * 
	 * @param price
	 */
	public void setPrice(IMoney price);

	/**
	 * Get brtand full name
	 * 
	 * @return String
	 */
	public String getBrandName();

}