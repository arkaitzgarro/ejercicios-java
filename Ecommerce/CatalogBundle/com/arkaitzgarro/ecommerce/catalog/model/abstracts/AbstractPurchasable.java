package com.arkaitzgarro.ecommerce.catalog.model.abstracts;

import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IBrand;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IMoney;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public abstract class AbstractPurchasable extends AbstractEntity {

	private final float VAT = 21;

	/**
	 * Product name
	 */
	protected String name;

	/**
	 * Product price
	 */
	protected IMoney price;

	/**
	 * Product brand
	 */
	private IBrand brand;

	public AbstractPurchasable() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#setName(java.lang.String
	 *      )
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#getBrand()
	 */
	public IBrand getBrand() {
		return brand;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#setBrand(com.arkaitzgarro
	 *      .ecommerce.catalog.model.interfaces.IBrand)
	 */
	public void setBrand(IBrand brand) {
		this.brand = brand;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#getPrice()
	 */
	public IMoney getPrice() {
		return this.price;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#getPriceWithoutVAT()
	 */
	public IMoney getPriceWithoutVAT() {
		return this.getPrice();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#getPriceWithVAT()
	 */
	public IMoney getPriceWithVAT() {
		return this.price.calculateWithTax(this.VAT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#setPrice(float)
	 */
	public void setPrice(float ammount) {
		this.getPrice().setAmmount(ammount);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#setPrice(com.arkaitzgarro
	 *      .ecommerce.catalog.model.interfaces.IMoney)
	 */
	public void setPrice(IMoney price) {
		this.price = price;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IProduct#getBrandName()
	 */
	public String getBrandName() {
		return this.getBrand().getName();
	}

}