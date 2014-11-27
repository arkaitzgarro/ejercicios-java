package com.arkaitzgarro.ecommerce.catalog.model;

import java.util.ArrayList;

import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IBrand;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IProduct;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public class Brand extends AbstractEntity implements IBrand, Cloneable {
	/**
	 * Brand name
	 */
	private String name;

	/**
	 * Brand logo
	 */
	private String logo;

	/**
	 * Brand description
	 */
	private String description;

	private ArrayList<IProduct> products;

	public Brand(String name) {
		this.name = name;
		this.products = new ArrayList<IProduct>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#getLogo()
	 */
	public String getLogo() {
		return this.logo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#setLogo(java.lang.String)
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#getDescription()
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#setDescription(java.lang
	 *      .String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#insertProduct(com.
	 *      arkaitzgarro.ecommerce.catalog.model.Product)
	 */
	public void insertProduct(IProduct product) {
		if (!this.getProducts().contains(product)) {
			// Insert only if not exists
			getProducts().add(product);

			product.setBrand(this);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#getProducts()
	 */
	public ArrayList<IProduct> getProducts() {
		return this.products;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.arkaitzgarro.ecommerce.catalog.model.IBrand#getProductCount()
	 */
	public int getProductCount() {
		return this.getProducts().size();
	}

}
