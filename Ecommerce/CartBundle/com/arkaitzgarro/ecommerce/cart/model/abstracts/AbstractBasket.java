package com.arkaitzgarro.ecommerce.cart.model.abstracts;

import java.util.ArrayList;

import com.arkaitzgarro.ecommerce.cart.model.interfaces.ILine;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IProduct;
import com.arkaitzgarro.ecommerce.core.model.abstracts.AbstractEntity;

public abstract class AbstractBasket extends AbstractEntity {

	private ArrayList<ILine> lines;

	public AbstractBasket() {
		lines = new ArrayList<ILine>();
	}

	/**
	 * Find a AbstractLine for the given product. Return null if not exist
	 * 
	 * @param p
	 * @return
	 */
	protected ILine findAbstractLine(IProduct p) {
		for (ILine abstractLine : lines) {
			if (abstractLine.getProduct().equals(p)) {
				return abstractLine;
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.arkaitzgarro.ecommerce.cart.model.abstracts.IBasket#getLines()
	 */
	public ArrayList<ILine> getLines() {
		return this.lines;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.IBasket#getTotalWithVAT()
	 */
	public float getTotalWithVAT() {
		float total = 0;

		for (ILine abstractLine : lines) {
			total += abstractLine.getTotalWithVAT();
		}

		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.IBasket#getTotalWithoutVAT
	 * ()
	 */
	public float getTotalWithoutVAT() {
		float total = 0;

		for (ILine abstractLine : lines) {
			total += abstractLine.getTotalWithoutVAT();
		}

		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.IBasket#getNumLines()
	 */
	public int getNumLines() {
		return this.lines.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.arkaitzgarro.ecommerce.cart.model.abstracts.IBasket#getNumProducts()
	 */
	public int getNumProducts() {
		int total = 0;

		for (ILine abstractLine : lines) {
			total += abstractLine.getQuantity();
		}

		return total;
	}
}
