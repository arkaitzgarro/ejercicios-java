package com.arkaitzgarro.ecommerce.core.model.abstracts;

import java.util.Date;

public abstract class AbstractEntity {
	/**
	 * Entity identifier
	 */
	private int id;

	/**
	 * When entity was created
	 */
	private Date createdAt;

	/**
	 * When entity was modified (last time)
	 */
	private Date updatedAt;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
