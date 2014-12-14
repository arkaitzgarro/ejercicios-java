package com.arkaitzgarro.jdbc.model.interfaces;

import java.util.Date;

import com.arkaitzgarro.jdbc.model.Language;

public interface IFilm {

	/**
	 * @return the id
	 */
	public long getId();

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id);

	/**
	 * @return the title
	 */
	public String getTitle();

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title);

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description);

	/**
	 * @return the year
	 */
	public Date getYear();

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(Date year);

	/**
	 * @return the language
	 */
	public Language getLanguage();

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(Language language);

}