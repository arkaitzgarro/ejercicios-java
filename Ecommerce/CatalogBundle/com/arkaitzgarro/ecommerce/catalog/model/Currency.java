package com.arkaitzgarro.ecommerce.catalog.model;

import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Currency extends AbstractEntity {
	/**
	 * Currency name
	 */
	private String name;

	/**
	 * Currency symbol
	 */
	private String symbol;

	/**
	 * Exchange rate from Euro to this currency
	 */
	private float exchangeRate;

	public Currency(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
		this.exchangeRate = 1;
	}

	/**
	 * @return Currency name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Currency name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Currency symbol
	 */
	public String getSymbol() {
		return this.symbol;
	}

	/**
	 * @param symbol
	 *            Currency symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return Exchange rate
	 */
	public float getExchangeRate() {
		return this.exchangeRate;
	}

	/**
	 * @param cambio
	 *            Exchange rate to set
	 */
	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
