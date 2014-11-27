package com.arkaitzgarro.ecommerce.catalog.model;

import com.arkaitzgarro.ecommerce.catalog.model.interfaces.ICurrency;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Currency extends AbstractEntity implements ICurrency {
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
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.ICurrency#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.ICurrency#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.ICurrency#getSymbol()
	 */
	public String getSymbol() {
		return this.symbol;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.ICurrency#setSymbol(java.lang
	 *      .String)
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.ICurrency#getExchangeRate()
	 */
	public float getExchangeRate() {
		return this.exchangeRate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.ICurrency#setExchangeRate(float)
	 */
	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
