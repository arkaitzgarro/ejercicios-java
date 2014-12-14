package com.arkaitzgarro.hibernate.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
	private static EntityManagerFactory emf = null;

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("PersistenceName");
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("Error al crear la factoria de JPA");
		}
	}

	public static EntityManagerFactory getJPAFactory() {
		if (emf == null) {
			emf = buildEntityManagerFactory();
		}

		return emf;
	}
}
