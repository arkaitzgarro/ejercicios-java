package com.arkaitzgarro.jdbc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.jdbc.model.Film;
import com.arkaitzgarro.jdbc.model.factory.FilmFactory;
import com.arkaitzgarro.jdbc.model.repository.FilmRepository;

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
	}

}
