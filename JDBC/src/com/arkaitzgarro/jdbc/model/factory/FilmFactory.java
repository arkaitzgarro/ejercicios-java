package com.arkaitzgarro.jdbc.model.factory;

import java.util.Date;

import com.arkaitzgarro.jdbc.model.Film;
import com.arkaitzgarro.jdbc.model.interfaces.IFilm;

public class FilmFactory {

	public IFilm create() {
		IFilm film = new Film();
		film.setYear(new Date());

		return film;
	}
}
