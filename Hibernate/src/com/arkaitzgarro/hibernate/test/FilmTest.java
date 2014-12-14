package com.arkaitzgarro.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.hibernate.factory.FilmFactory;
import com.arkaitzgarro.hibernate.model.Film;
import com.arkaitzgarro.hibernate.model.Language;
import com.arkaitzgarro.hibernate.repository.FilmRepository;
import com.arkaitzgarro.hibernate.repository.LanguageRepository;

public class FilmTest {

	static FilmRepository filmRepository;
	static LanguageRepository langRepository;
	static FilmFactory filmFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		filmRepository = new FilmRepository();
		langRepository = new LanguageRepository();
		filmFactory = new FilmFactory();
	}

	@Test
	public void testRepository() {
		List<Film> films = filmRepository.findAll();
		assertNotEquals(0, films.size());

		Film film = filmRepository.findOneById(1);
		assertTrue(film instanceof Film);
		assertEquals(1, film.getId());

		films = filmRepository.findByStr("DINOSAUR");
		assertNotEquals(0, films.size());

		Film newFilm = filmFactory.create();
		newFilm.setTitle("Interstellar");
		newFilm.setDescription("A group of explorers must travel beyond our solar system in search of a planet that can sustain life. The crew of the Endurance are required to think bigger and go further than any human in history as they embark on an interstellar voyage, into the unknown.");
		newFilm.setLanguage(langRepository.findOneById(1));
		// newFilm.setYear(new Date());
		//
		assertEquals(0, newFilm.getId());
		assertTrue(filmRepository.save(newFilm));
		assertNotEquals(0, newFilm.getId());

		newFilm.setTitle("Interstellar 2014");
		assertTrue(filmRepository.save(newFilm));

		Film otherFilm = filmRepository.findOneById(newFilm.getId());
		assertEquals(newFilm.getId(), otherFilm.getId(), 0);
		assertEquals("Interstellar 2014", otherFilm.getTitle());

		assertTrue(filmRepository.delete(newFilm));
	}

	@Test
	public void testLanguageRelation() {
		Film film = filmRepository.findOneById(1);
		assertTrue(film instanceof Film);
		assertEquals(1, film.getId());

		assertTrue(film.getLanguage() instanceof Language);
		assertEquals(film.getLanguage().getId(), 1);
	}
}
