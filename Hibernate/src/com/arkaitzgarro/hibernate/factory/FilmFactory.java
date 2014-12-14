package com.arkaitzgarro.hibernate.factory;

import com.arkaitzgarro.hibernate.model.Film;

public class FilmFactory {

	public Film create() {
		Film film = new Film();

		return film;
	}
}
