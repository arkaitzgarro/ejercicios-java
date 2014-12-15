package com.arkaitzgarro.hibernate.repository.abstracts;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.arkaitzgarro.hibernate.repository.interfaces.IRepository;
import com.arkaitzgarro.hibernate.util.JPAHelper;

public abstract class BaseJPARepository<T, Id extends Serializable> implements
		IRepository<T, Id> {

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseJPARepository() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll() {

		List<T> list = null;

		EntityManagerFactory sessionFactory = JPAHelper.getJPAFactory();
		EntityManager manager = sessionFactory.createEntityManager();

		try {
			TypedQuery<T> query = manager.createQuery("select o from "
					+ entityClass.getSimpleName() + " o", entityClass);

			list = query.getResultList();
		} finally {
			manager.close();
		}

		return list;
	}

	public T findOneById(Id id) {

		T obj = null;

		EntityManagerFactory sessionFactory = JPAHelper.getJPAFactory();
		EntityManager manager = sessionFactory.createEntityManager();

		try {
			obj = (T) manager.find(entityClass, id);
		} finally {
			manager.close();
		}

		return obj;
	}

	public boolean insert(T obj) {

		EntityManagerFactory sessionFactory = JPAHelper.getJPAFactory();
		EntityManager manager = sessionFactory.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = manager.getTransaction();

			tx.begin();
			manager.persist(obj);
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			tx.rollback();

			return false;
		} finally {
			manager.close();
		}

		return true;
	}

	public boolean update(T obj) {

		EntityManagerFactory sessionFactory = JPAHelper.getJPAFactory();
		EntityManager manager = sessionFactory.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = manager.getTransaction();

			tx.begin();
			manager.merge(obj);
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			tx.rollback();

			return false;
		} finally {
			manager.close();
		}

		return true;
	}

	public boolean delete(T obj) {

		EntityManagerFactory sessionFactory = JPAHelper.getJPAFactory();
		EntityManager manager = sessionFactory.createEntityManager();

		EntityTransaction tx = null;

		try {
			tx = manager.getTransaction();

			tx.begin();
			manager.remove(manager.merge(obj));
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			tx.rollback();

			return false;
		} finally {
			manager.close();
		}

		return true;
	}
}
