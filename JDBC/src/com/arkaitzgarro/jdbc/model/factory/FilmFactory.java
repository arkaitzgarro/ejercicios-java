package com.arkaitzgarro.jdbc.model.factory;

import java.util.Date;

import com.arkaitzgarro.jdbc.model.Film;

public class FilmFactory {

	public Film create() {
		Film film = new Film();
		film.setYear(new Date());

		return film;
	}
}
