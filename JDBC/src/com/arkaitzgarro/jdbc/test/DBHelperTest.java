package com.arkaitzgarro.jdbc.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.jdbc.db.DataBaseHelper;

public class DBHelperTest {

	static DataBaseHelper dbHelper = null;

	@BeforeClass
	public static void setUpClass() {
		try {
			dbHelper = new DataBaseHelper();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		assertNotNull(dbHelper);
	}

	@Test
	public void testQuery() {
		assertNotNull(dbHelper);

		assertNotNull(dbHelper.query("SELECT * FROM actor;"));
	}

	@Test
	public void testExecute() {
		assertNotNull(dbHelper);

		assertNotEquals(
				0,
				dbHelper.execute("UPDATE city SET last_update = NOW() WHERE city_id = 1;"));
	}
}
