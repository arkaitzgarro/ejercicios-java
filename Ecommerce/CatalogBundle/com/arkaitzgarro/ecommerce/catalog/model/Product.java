package com.arkaitzgarro.ecommerce.catalog.model;

import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Product extends AbstractEntity {

	private final float VAT = 21;

	/**
	 * Product name
	 */
	private String name;

	/**
	 * Product brand
	 */
	private Brand brand;

	/**
	 * Product price
	 */
	private Money price;

	/**
	 * Stock
	 */
	private int stock;

	/**
	 * Create a new product with a given name and brand
	 * 
	 * @param nombre
	 *            Nombre del producto
	 * @param marca
	 *            Nombre de la marca
	 */
	public Product(String name, Brand brand) {
		this.name = name;
		this.setBrand(brand);
		this.price = new Money(0, new Currency("Euro", "€"));
		this.setStock(0);
	}

	/**
	 * Get product name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set product name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get brand
	 * 
	 * @return Get the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            Set the brand for this product
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;

		this.brand.insertProduct(this);
	}

	/**
	 * Get the price
	 * 
	 * @return
	 */
	public Money getPrice() {
		return this.price;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(int stock) {
		this.stock = (stock < 0) ? 0 : stock;
	}

	/**
	 * Get the price without VAT
	 * 
	 * @return
	 */
	public Money getPriceWithoutVAT() {
		return this.getPrice();
	}

	/**
	 * Get the price with VAT
	 * 
	 * @return
	 */
	public Money getPriceWithVAT() {
		return this.price.calculateWithTax(this.VAT);
	}

	/**
	 * Get rounded price
	 * 
	 * @return
	 */
	public int getPrecioRedondeado() {
		return (int) Math.ceil(this.getPriceWithVAT().getAmmount());
	}

	/**
	 * Set money (ammount) for this price
	 * 
	 * @param price
	 *            Set the price for this product
	 */
	public void setPrice(float ammount) {
		this.price.setAmmount(ammount);
	}

	/**
	 * Set the price for this product
	 * 
	 * @param price
	 */
	public void setPrice(Money price) {
		this.price = price;
	}

	/**
	 * Get brtand full name
	 * 
	 * @return String
	 */
	public String getBrandName() {
		return this.brand.getName();
	}

	/**
	 * Prints product data
	 */
	@Override
	public String toString() {
		return this.getName() + " " + this.getBrandName() + " "
				+ this.getPrice();
	}

	/**
	 * Compare this product with a given one
	 */
	@Override
	public boolean equals(Object tmp) {
		Product p = (Product) tmp;

		return p.getName().equals(this.getName())
				&& p.getBrandName().equals(this.getBrandName());

	}

	public Product clone() {
		return this.clone();
	}
}
