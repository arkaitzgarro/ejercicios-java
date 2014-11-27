package com.arkaitzgarro.ecommerce.catalog.model.interfaces;

public interface IBrand {

	/**
	 * @return Brand name
	 */
	public String getName();

	/**
	 * @param name
	 *            Brand name to set
	 */
	public void setName(String name);

	/**
	 * @return the logo
	 */
	public String getLogo();

	/**
	 * @param logo
	 *            Brand logo to set
	 */
	public void setLogo(String logo);

	/**
	 * @return Brand description
	 */
	public String getDescription();

	/**
	 * @param description
	 *            Brand description to set
	 */
	public void setDescription(String description);

	/**
	 * Insert a nre product
	 * 
	 * @param product
	 */
	public void insertProduct(IProduct product);

	/**
	 * Gell all products for this brand
	 * 
	 * @return Product list
	 */
	public Iterable<IProduct> getProducts();

	/**
	 * Get the number of this products for this brand
	 * 
	 * @return
	 */
	public int getProductCount();

}