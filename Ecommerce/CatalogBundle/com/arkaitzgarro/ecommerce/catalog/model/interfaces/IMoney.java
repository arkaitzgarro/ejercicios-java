package com.arkaitzgarro.ecommerce.catalog.model.interfaces;

public interface IMoney {

	/**
	 * @return Money ammount
	 */
	public float getAmmount();

	/**
	 * @param ammount
	 *            The ammount for this money
	 */
	public void setAmmount(float ammount);

	/**
	 * @return Money currency
	 */
	public ICurrency getCurrency();

	/**
	 * @param currency
	 *            The currency to set
	 */
	public void setCurrency(ICurrency currency);

	/**
	 * Calculate final price with given VAT
	 * 
	 * @param VAT
	 * @return New price
	 */
	public IMoney calculateWithTax(float VAT);

}