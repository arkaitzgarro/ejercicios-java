package com.arkaitzgarro.hibernate.repository;

import java.util.List;

import org.hibernate.Session;

import com.arkaitzgarro.hibernate.model.Film;
import com.arkaitzgarro.hibernate.util.HibernateUtil;

public class FilmRepository {

	private Session session;

	public FilmRepository() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public List<Film> findAll() {

		return null;
	}

	public Film findOneById(long id) {

		return null;
	}

	public boolean insert(Film film) {

		return false;
	}

	public boolean update(Film film) {

		return false;
	}

	public boolean delete(Film film) {

		return false;
	}

}
