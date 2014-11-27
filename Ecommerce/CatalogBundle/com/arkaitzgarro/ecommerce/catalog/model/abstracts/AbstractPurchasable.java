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
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#setName(java.lang.String
	 *      )
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#getBrand()
	 */
	public IBrand getBrand() {
		return brand;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#setBrand(com.arkaitzgarro
	 *      .ecommerce.catalog.model.interfaces.IBrand)
	 */
	public void setBrand(IBrand brand) {
		this.brand = brand;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#getPrice()
	 */
	public IMoney getPrice() {
		return this.price;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#getPriceWithoutVAT()
	 */
	public IMoney getPriceWithoutVAT() {
		return this.getPrice();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#getPriceWithVAT()
	 */
	public IMoney getPriceWithVAT() {
		return this.price.calculateWithTax(this.VAT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#setPrice(float)
	 */
	public void setPrice(float ammount) {
		this.getPrice().setAmmount(ammount);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#setPrice(com.arkaitzgarro
	 *      .ecommerce.catalog.model.interfaces.IMoney)
	 */
	public void setPrice(IMoney price) {
		this.price = price;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IPurchasable#getBrandName()
	 */
	public String getBrandName() {
		return this.getBrand().getName();
	}

}