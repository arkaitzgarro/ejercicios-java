package com.arkaitzgarro.ecommerce.catalog.model.interfaces;

public interface ICurrency {

	/**
	 * @return Currency name
	 */
	public String getName();

	/**
	 * @param name
	 *            Currency name to set
	 */
	public void setName(String name);

	/**
	 * @return Currency symbol
	 */
	public String getSymbol();

	/**
	 * @param symbol
	 *            Currency symbol to set
	 */
	public void setSymbol(String symbol);

	/**
	 * @return Exchange rate
	 */
	public float getExchangeRate();

	/**
	 * @param cambio
	 *            Exchange rate to set
	 */
	public void setExchangeRate(float exchangeRate);

}