package com.arkaitzgarro.ecommerce.catalog.model;

import java.util.ArrayList;

import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Brand extends AbstractEntity {
	/**
	 * Brand name
	 */
	private String name;

	/**
	 * Brand logo
	 */
	private String logo;

	/**
	 * Brand description
	 */
	private String description;

	private ArrayList<Product> products;

	public Brand(String name) {
		this.name = name;
		this.products = new ArrayList<Product>();
	}

	/**
	 * @return Brand name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Brand name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return this.logo;
	}

	/**
	 * @param logo
	 *            Brand logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return Brand description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            Brand description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Insert a nre product
	 * 
	 * @param product
	 */
	public void insertProduct(Product product) {
		if (!this.products.contains(product)) {
			// Insert only if not exists
			products.add(product);

			product.setBrand(this);
		}
	}

	/**
	 * Gell all products for this brand
	 * 
	 * @return Product list
	 */
	public ArrayList<Product> getProducts() {
		return this.products;
	}

	/**
	 * Get the number of this products for this brand
	 * 
	 * @return
	 */
	public int getProductCount() {
		return this.products.size();
	}
}
