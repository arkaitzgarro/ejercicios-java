package com.arkaitzgarro.videoclub.model;

import java.io.Serializable;

import com.arkaitzgarro.jdbc.model.interfaces.IFilm;

public class Film extends com.arkaitzgarro.jdbc.model.Film implements
		Serializable, IFilm {

	private static final long serialVersionUID = 3299611765216223206L;

	@Override
	public boolean equals(Object obj) {
		return this.getId() == ((com.arkaitzgarro.jdbc.model.Film) obj).getId();
	}
}
