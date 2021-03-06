package com.arkaitzgarro.hibernate.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arkaitzgarro.hibernate.model.Film;
import com.arkaitzgarro.hibernate.util.HibernateHelper;

public class FilmRepository {

	private SessionFactory sessionFactory;

	public FilmRepository() {
		try {
			sessionFactory = HibernateHelper.getSessionFactory();
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Buscar todas las películas en la base de datos
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Film> findAll() {

		Session session = null;
		List<Film> list = null;

		try {
			session = sessionFactory.openSession();

			Query q = session.createQuery("FROM Film");
			list = (List<Film>) q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * Buscar una película por ID
	 * 
	 * @param id
	 * @return
	 */
	public Film findOneById(long id) {

		Session session = null;
		Film film = null;

		try {
			session = sessionFactory.openSession();

			film = (Film) session.get(Film.class, id);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		return film;
	}

	/**
	 * Buscar películas por nombre o descripción
	 * 
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Film> findByStr(String str) {
		
		Session session = null;
		List<Film> list = null;

		try {
			session = sessionFactory.openSession();

			Query q = session
					.createQuery("FROM Film film WHERE film.title LIKE :str OR film.description LIKE :str");
			q.setString("str", "%" + str + "%");

			list = (List<Film>) q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * Guardar (actualiza o inserta) la película en la base de datos
	 * 
	 * @param film
	 * @return
	 */
	public boolean save(Film film) {
		
		boolean ok = false;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.saveOrUpdate(film);
			session.getTransaction().commit();
			
			ok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			try {
				session.close();
			} catch(HibernateException e) {
				e.printStackTrace();
			}
		}

		return ok;
	}

	/**
	 * Eliminar una película de la base de datos
	 * 
	 * @param film
	 * @return
	 */
	public boolean delete(Film film) {

		boolean ok = false;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.delete(film);
			session.getTransaction().commit();
			
			ok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch(HibernateException e) {
				e.printStackTrace();
			}
		}

		return ok;
	}

}
