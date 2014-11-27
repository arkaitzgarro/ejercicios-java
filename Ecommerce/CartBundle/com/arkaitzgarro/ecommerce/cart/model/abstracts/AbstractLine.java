package com.arkaitzgarro.ecommerce.cart.model.abstracts;

import com.arkaitzgarro.ecommerce.cart.model.interfaces.ILine;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IPurchasable;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public abstract class AbstractLine extends AbstractEntity {

	/**
	 * Product
	 */
	private IPurchasable product;

	/**
	 * Quantity
	 */
	private int quantity;

	public AbstractLine(IPurchasable product, int quantity) {
		this.product = product;
		this.setQuantity(quantity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.arkaitzgarro.ecommerce.cart.model.abstracts.ILine#getProduct()
	 */
	public IPurchasable getProduct() {
		return product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.ILine#setProduct(com.
	 * arkaitzgarro.ecommerce.catalog.model.interfaces.IProduct)
	 */
	public void setProduct(IPurchasable product) {
		this.product = product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.arkaitzgarro.ecommerce.cart.model.abstracts.ILine#getQuantity()
	 */
	public int getQuantity() {
		return quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.ILine#setQuantity(int)
	 */
	public void setQuantity(int quantity) {
		this.quantity = (quantity < 1) ? 1 : quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.ILine#getTotalWithVAT()
	 */
	public float getTotalWithVAT() {
		return this.quantity * this.product.getPriceWithVAT().getAmmount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.ILine#getTotalWithoutVAT
	 * ()
	 */
	public float getTotalWithoutVAT() {
		return this.quantity * this.product.getPriceWithoutVAT().getAmmount();
	}

	@Override
	public boolean equals(Object o) {
		ILine cl = (ILine) o;

		return this.getProduct().equals(cl.getProduct());
	}
}
