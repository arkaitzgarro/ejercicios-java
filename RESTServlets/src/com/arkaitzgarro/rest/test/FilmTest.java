package com.arkaitzgarro.rest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.jdbc.model.Film;
import com.arkaitzgarro.jdbc.model.factory.FilmFactory;
import com.arkaitzgarro.jdbc.model.interfaces.IFilm;
import com.arkaitzgarro.jdbc.model.repository.FilmRepository;

public class FilmTest {
	static FilmRepository filmRepository;
	static FilmFactory filmFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		filmRepository = new FilmRepository();
		filmFactory = new FilmFactory();
	}

	@Test
	public void testFactory() {
		IFilm film = filmFactory.create();

		assertTrue(film instanceof Film);
	}

	@Test
	public void testRepository() {
		List<IFilm> films = filmRepository.findAll();
		assertNotEquals(0, films.size());

		IFilm film = filmRepository.findOneById(1);
		assertTrue(film instanceof Film);
		assertEquals(1, film.getId());

		IFilm newFilm = filmFactory.create();
		newFilm.setTitle("Interstellar");
		newFilm.setDescription("A group of explorers must travel beyond our solar system in search of a planet that can sustain life. The crew of the Endurance are required to think bigger and go further than any human in history as they embark on an interstellar voyage, into the unknown.");
		newFilm.setYear(new Date());

		assertEquals(0, newFilm.getId());
		assertTrue(filmRepository.insert(newFilm));
		assertNotEquals(0, newFilm.getId());

		newFilm.setTitle("Interstellar 2014");
		assertTrue(filmRepository.update(newFilm));

		IFilm otherFilm = filmRepository.findOneById(newFilm.getId());
		assertEquals(newFilm.getId(), otherFilm.getId());
		assertEquals("Interstellar 2014", otherFilm.getTitle());

		assertTrue(filmRepository.delete(newFilm));
	}
}
