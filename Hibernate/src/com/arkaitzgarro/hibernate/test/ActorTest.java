package com.arkaitzgarro.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.hibernate.model.Actor;
import com.arkaitzgarro.hibernate.repository.ActorRepository;

public class ActorTest {

	static ActorRepository actorRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		actorRepository = new ActorRepository();
	}

	@Test
	public void testRepository() {
		List<Actor> actors = actorRepository.findAll();
		assertNotEquals(0, actors.size());

		Actor actor = actorRepository.findOneById(new Long(1));
		assertTrue(actor instanceof Actor);
		assertEquals(1, actor.getId());

		actors = actorRepository.findByStr("PENELOPE");
		assertNotEquals(0, actors.size());

		assertNotEquals(0, actor.getFilms().size());
	}

}
