package com.arkaitzgarro.ecommerce.catalog.model;

import com.arkaitzgarro.ecommerce.catalog.model.abstracts.AbstractPurchasable;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IBrand;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IPurchasable;

public class Product extends AbstractPurchasable implements IPurchasable,
		Cloneable {

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
	public Product(String name, IBrand brand) {
		this.name = name;
		this.setBrand(brand);
		this.price = new Money(0, new Currency("Euro", "€"));
		this.setStock(0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#getStock()
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#setStock(int)
	 */
	public void setStock(int stock) {
		this.stock = (stock < 0) ? 0 : stock;
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

	/**
	 * Create a copy of this object
	 */
	public Product clone() {
		Product obj = null;

		try {
			obj = (Product) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obj.price = ((Money) obj.price).clone();

		return obj;
	}
}
