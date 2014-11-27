package com.arkaitzgarro.ecommerce.catalog.model;

import com.arkaitzgarro.ecommerce.catalog.model.interfaces.ICurrency;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IMoney;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Money extends AbstractEntity implements IMoney {

	/**
	 * Ammount
	 */
	private float ammount;

	/**
	 * Currency for this money
	 */
	private ICurrency currency;

	public Money(float ammount, ICurrency currency) {
		this.setAmmount(ammount);
		this.setCurrency(currency);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IMoney#getAmmount()
	 */
	public float getAmmount() {
		return ammount;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IMoney#setAmmount(float)
	 */
	public void setAmmount(float ammount) {
		this.ammount = (ammount < 0) ? 0 : ammount;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IMoney#getCurrency()
	 */
	public ICurrency getCurrency() {
		return currency;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IMoney#setCurrency(com.arkaitzgarro
	 *      .ecommerce.catalog.model.Currency)
	 */
	public void setCurrency(ICurrency currency) {
		this.currency = currency;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IMoney#calculateWithTax(float)
	 */
	public IMoney calculateWithTax(float VAT) {
		float finalPrice = this.ammount + (this.ammount / 100 * VAT);

		return new Money(finalPrice, this.currency);
	}

}
