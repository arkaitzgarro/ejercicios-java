package com.arkaitzgarro.rest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.rest.model.Film;
import com.arkaitzgarro.rest.model.factory.FilmFactory;
import com.arkaitzgarro.rest.model.repository.FilmRepository;

public class FilmTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testFactory() {
		Film film = FilmFactory.create();

		assertTrue(film instanceof Film);
	}

	@Test
	public void testRepository() {
		Film film = FilmRepository.findOneById(1);

		assertTrue(film instanceof Film);
		assertEquals(1, film.getId());

		Film newFilm = FilmFactory.create();
		newFilm.setTitle("Interstellar");
		newFilm.setDescription("A group of explorers must travel beyond our solar system in search of a planet that can sustain life. The crew of the Endurance are required to think bigger and go further than any human in history as they embark on an interstellar voyage, into the unknown.");
		newFilm.setYear(new Date());

		assertTrue(FilmRepository.addFilm(newFilm));
		assertNotEquals(0, newFilm.getId());

		newFilm.setTitle("Interstellar 2014");
		assertTrue(FilmRepository.updateFilm(newFilm));

		Film otherFilm = FilmRepository.findOneById(newFilm.getId());
		assertEquals(newFilm.getId(), otherFilm.getId());
		assertEquals("Interstellar 2014", otherFilm.getTitle());

		assertTrue(FilmRepository.removeFilm(newFilm));
	}
}
