package com.arkaitzgarro.rest.model.factory;

import com.arkaitzgarro.rest.model.Film;

public abstract class FilmFactory {

	public static Film create() {
		Film film = new Film();

		return film;
	}
}
