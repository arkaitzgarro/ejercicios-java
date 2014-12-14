package com.arkaitzgarro.hibernate.repository;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.arkaitzgarro.hibernate.model.Film;
import com.arkaitzgarro.hibernate.util.HibernateUtil;

public class FilmRepository {

	private SessionFactory sessionFactory;

	public FilmRepository() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	/**
	 * Buscar todas las pel’culas en la base de datos
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Film> findAll() {

		List<Film> list = null;

		try {
			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from Film");
			list = (List<Film>) q.list();

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

			return null;
		}

		return list;
	}

	/**
	 * Buscar una pel’cula por ID
	 * 
	 * @param id
	 * @return
	 */
	public Film findOneById(long id) {

		Film film = null;

		try {
			Session session = sessionFactory.openSession();

			film = (Film) session.get(Film.class, id);

			film = (Film) session.createCriteria(Film.class)
					.setFetchMode("language", FetchMode.JOIN)
					.add(Restrictions.idEq(id)).uniqueResult();

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

			return null;
		}

		return film;
	}

	/**
	 * Buscar pel’culas por nombre o descripci—n
	 * 
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Film> findByStr(String str) {
		List<Film> list = null;

		try {
			Session session = sessionFactory.openSession();

			Query q = session
					.createQuery("FROM Film film WHERE film.title LIKE :str OR film.description LIKE :str");
			q.setString("str", "%" + str + "%");

			list = (List<Film>) q.list();

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

			return null;
		}

		return list;
	}

	/**
	 * Guardar (actualiza o inserta) la pel’cula en la base de datos
	 * 
	 * @param film
	 * @return
	 */
	public boolean save(Film film) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(film);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}

		return true;
	}

	/**
	 * Eliminar una pel’cula de la base de datos
	 * 
	 * @param film
	 * @return
	 */
	public boolean delete(Film film) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.delete(film);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}

		return true;
	}

}
