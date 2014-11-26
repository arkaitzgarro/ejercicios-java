package com.arkaitzgarro.ecommerce.cart.model.abstracts;

import com.arkaitzgarro.ecommerce.catalog.model.Product;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public abstract class AbstractLine extends AbstractEntity {

	/**
	 * Product
	 */
	private Product product;

	/**
	 * Quantity
	 */
	private int quantity;

	public AbstractLine(Product product, int quantity) {
		this.product = product;
		this.setQuantity(quantity);
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = (quantity < 1) ? 1 : quantity;
	}

	/**
	 * Get total with VAT included
	 * 
	 * @return
	 */
	public float getTotalWithVAT() {
		return this.quantity * this.product.getPriceWithVAT().getAmmount();
	}

	/**
	 * Get total without VAT
	 * 
	 * @return
	 */
	public float getTotalWithoutVAT() {
		return this.quantity * this.product.getPriceWithoutVAT().getAmmount();
	}

	@Override
	public boolean equals(Object o) {
		AbstractLine cl = (AbstractLine) o;

		return this.getProduct().equals(cl.getProduct());
	}
}
