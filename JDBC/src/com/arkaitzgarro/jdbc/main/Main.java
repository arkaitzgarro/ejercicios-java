package com.arkaitzgarro.jdbc.main;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
	private Connection oconn;

	public Main() {
		try {
			oconn = DB.getConnection();
		} catch (SQLException e) {
			System.out.println("Unable to connect to DB.");
			e.printStackTrace();
		}
	}

}
