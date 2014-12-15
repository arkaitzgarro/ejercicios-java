package com.arkaitzgarro.hibernate.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.arkaitzgarro.hibernate.util.HibernateHelper;

public class HibernateHelperTest {

	@Test
	public void testSessionFactory() {
		try {
			SessionFactory sf = HibernateHelper.getSessionFactory();
			assertNotNull(sf);
		} catch(ExceptionInInitializerError ex) {
			fail(ex.getMessage());
		}
	}

}
