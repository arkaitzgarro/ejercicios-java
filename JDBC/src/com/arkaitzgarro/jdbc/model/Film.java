package com.arkaitzgarro.jdbc.model;

import java.util.Date;

import com.arkaitzgarro.jdbc.model.interfaces.IFilm;

public class Film implements IFilm {

	/**
	 * Database id
	 */
	private long id;

	/**
	 * Title
	 */
	private String title;

	/**
	 * Description
	 */
	private String description;

	/**
	 * Year
	 */
	private Date year;

	/**
	 * Film language
	 */
	private Language language;

	/**
	 * @return the id
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the year
	 */
	@Override
	public Date getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	@Override
	public void setYear(Date year) {
		this.year = year;
	}

	/**
	 * @return the language
	 */
	@Override
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	@Override
	public void setLanguage(Language language) {
		this.language = language;
	}

}
