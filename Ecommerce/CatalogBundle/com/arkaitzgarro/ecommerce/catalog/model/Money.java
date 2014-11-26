package com.arkaitzgarro.ecommerce.catalog.model;

import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Money extends AbstractEntity {

	/**
	 * Ammount
	 */
	private float ammount;

	/**
	 * Currency for this money
	 */
	private Currency currency;

	public Money(float ammount, Currency currency) {
		this.setAmmount(ammount);
		this.setCurrency(currency);
	}

	/**
	 * @return Money ammount
	 */
	public float getAmmount() {
		return ammount;
	}

	/**
	 * @param ammount
	 *            The ammount for this money
	 */
	public void setAmmount(float ammount) {
		this.ammount = (ammount < 0) ? 0 : ammount;
	}

	/**
	 * @return Money currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            The currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Calculate final price with given VAT
	 * 
	 * @param VAT
	 * @return New price
	 */
	public Money calculateWithTax(float VAT) {
		float finalPrice = this.ammount + (this.ammount / 100 * VAT);

		return new Money(finalPrice, this.currency);
	}

}
