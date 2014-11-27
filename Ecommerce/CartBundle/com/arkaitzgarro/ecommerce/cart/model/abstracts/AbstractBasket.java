package com.arkaitzgarro.ecommerce.cart.model.abstracts;

import java.util.ArrayList;

import com.arkaitzgarro.ecommerce.catalog.model.Product;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public abstract class AbstractBasket extends AbstractEntity {

	private ArrayList<AbstractLine> lines;

	public AbstractBasket() {
		lines = new ArrayList<AbstractLine>();
	}

	/**
	 * Find a AbstractLine for the given product. Return null if not exist
	 * 
	 * @param p
	 * @return
	 */
	protected AbstractLine findAbstractLine(Product p) {
		for (AbstractLine abstractLine : lines) {
			if (abstractLine.getProduct().equals(p)) {
				return abstractLine;
			}
		}

		return null;
	}

	/**
	 * Get all lines
	 * 
	 * @return
	 */
	protected ArrayList<AbstractLine> getLines() {
		return this.lines;
	}

	/**
	 * Get cart total ammount, with VAT
	 * 
	 * @return
	 */
	public float getTotalWithVAT() {
		float total = 0;

		for (AbstractLine abstractLine : lines) {
			total = abstractLine.getTotalWithVAT();
		}

		return total;
	}

	/**
	 * Get cart total ammount, without VAT
	 * 
	 * @return
	 */
	public float getTotalWithoutVAT() {
		float total = 0;

		for (AbstractLine abstractLine : lines) {
			total = abstractLine.getTotalWithoutVAT();
		}

		return total;
	}

	/**
	 * Get number of lines
	 * 
	 * @return
	 */
	public int getNumLines() {
		return this.lines.size();
	}

	/**
	 * Get total number of products
	 * 
	 * @return
	 */
	public int getNumProducts() {
		int total = 0;

		for (AbstractLine abstractLine : lines) {
			total += abstractLine.getQuantity();
		}

		return total;
	}
}
