package com.arkaitzgarro.jdbc.model.factory;

import com.arkaitzgarro.jdbc.model.Film;

public abstract class FilmFactory {

	public static Film create() {
		Film film = new Film();

		return film;
	}
}
