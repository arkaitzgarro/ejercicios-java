package com.arkaitzgarro.hibernate.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arkaitzgarro.hibernate.model.Language;
import com.arkaitzgarro.hibernate.util.HibernateHelper;

public class LanguageRepository {

	private SessionFactory sessionFactory;

	public LanguageRepository() {
		sessionFactory = HibernateHelper.getSessionFactory();
	}

	/**
	 * Buscar todas los idiomas en la base de datos
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Language> findAll() {

		List<Language> list = null;

		try {
			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from Language");
			list = (List<Language>) q.list();

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

			return null;
		}

		return list;
	}

	/**
	 * Buscar un idioma por ID
	 * 
	 * @param id
	 * @return
	 */
	public Language findOneById(long id) {

		Language lang = null;

		try {
			Session session = sessionFactory.openSession();

			lang = (Language) session.get(Language.class, id);

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();

			return null;
		}

		return lang;
	}

	/**
	 * Guardar (actualiza o inserta) un idioma en la base de datos
	 * 
	 * @param lang
	 * @return
	 */
	public boolean save(Language lang) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(lang);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}

		return true;
	}

	/**
	 * Eliminar un idioma de la base de datos
	 * 
	 * @param lang
	 * @return
	 */
	public boolean delete(Language lang) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.delete(lang);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}

		return true;
	}

}
