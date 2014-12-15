package com.arkaitzgarro.hibernate.repository.abstracts;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arkaitzgarro.hibernate.repository.interfaces.IRepository;
import com.arkaitzgarro.hibernate.util.HibernateHelper;

public abstract class BaseHibernateRepository<T, Id extends Serializable> implements IRepository<T, Id> {

	private Class<T> entityClass;
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseHibernateRepository() {
		try {
			sessionFactory = HibernateHelper.getSessionFactory();
			this.entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		} catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T findOneById(Id id) {
		Session session = null;
		T obj = null;

		try {
			session = sessionFactory.openSession();

			obj = (T) session.get(this.entityClass, id);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		return obj;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = null;
		List<T> list = null;

		try {
			session = sessionFactory.openSession();

			Query q = session.createQuery("FROM " + this.entityClass.getCanonicalName());
			list = (List<T>) q.list();
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

	@Override
	public boolean update(T obj) {
		boolean ok = false;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.saveOrUpdate(obj);
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

	@Override
	public boolean insert(T obj) {
		return this.update(obj);
	}

	@Override
	public boolean delete(T obj) {
		boolean ok = false;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.delete(obj);
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
