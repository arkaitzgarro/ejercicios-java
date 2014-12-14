package com.arkaitzgarro.hibernate.repository.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IRepository<T, Id extends Serializable> {
	/**
	 * Buscar en la basw de datos, un objeto de tipo T y clave primaria id
	 * 
	 * @param id
	 * @return
	 */
	T findOneById(Id id);

	/**
	 * Devlver una lista con todos los objetos de clase T
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * Dado un objeto de clase T, actualizarlo en la base de datos
	 * 
	 * @param obj
	 * @return
	 */
	boolean update(T obj);

	/**
	 * Dado un objeto de clase T, insertarlo en la base de datos
	 * 
	 * @param obj
	 * @return
	 */
	boolean insert(T obj);

	/**
	 * Dado un objeto de clase T, eliminarlo de la base de datos
	 * 
	 * @param obj
	 * @return
	 */
	boolean delete(T obj);
}
