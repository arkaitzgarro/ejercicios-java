package com.arkaitzgarro.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {
	private Connection oconn = null;

	private String url = "jdbc:mysql://127.0.0.1/sakila";
	private String user = "sakila";
	private String pass = "sakila";

	/**
	 * Conexi—n con la Base de datos
	 * 
	 * @throws SQLException
	 */
	public DataBaseHelper() throws SQLException {
		// Class.forName("com.mysql.jdbc.Driver");
		try {
			oconn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// A–adir el error a un log
			System.out.println("No se ha podido conectar con la BD");

			throw e;
		}

	}

	/**
	 * Ejecutar una consulta SELECT
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet query(String sql) {

		ResultSet rows = null;

		try {
			Statement query = oconn.createStatement();
			rows = query.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	/**
	 * Ejecuta la sentencia en la BD (INSERT, UPDATE, DELETE)
	 * 
	 * @param sql
	 */
	public int execute(String sql) {
		int rowsAffected = 0;

		try {
			Statement query = oconn.createStatement();
			rowsAffected = query.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}

	/**
	 * Crear y almacenar una sentencia en la BD (INSERT, UPDATE, DELETE)
	 * 
	 * @param sql
	 * @return
	 */
	public PreparedStatement queryPrepared(String sql) {
		PreparedStatement query = null;

		try {
			query = oconn
					.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return query;
	}
}
