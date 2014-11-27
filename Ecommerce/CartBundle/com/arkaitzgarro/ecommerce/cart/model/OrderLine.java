package com.arkaitzgarro.ecommerce.cart.model;

import com.arkaitzgarro.ecommerce.cart.model.abstracts.AbstractLine;
import com.arkaitzgarro.ecommerce.cart.model.interfaces.ILine;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IProduct;

public class OrderLine extends AbstractLine implements ILine {

	private Order order;

	public OrderLine(IProduct p, int quantity, Order order) {
		super(p, quantity);

		this.setOrder(order);
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

}
