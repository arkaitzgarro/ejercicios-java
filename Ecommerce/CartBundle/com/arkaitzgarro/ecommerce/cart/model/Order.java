package com.arkaitzgarro.ecommerce.cart.model;

import com.arkaitzgarro.ecommerce.cart.model.abstracts.AbstractBasket;

public class Order extends AbstractBasket {

	private String reference;

	/**
	 * Actual order status
	 */
	private Status status;

	public Order() {
		super();

		status = Status.CREATED;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	public enum Status {
		CREATED, NOT_PAID, PAID_FAILED, PAYED;
	}
}
