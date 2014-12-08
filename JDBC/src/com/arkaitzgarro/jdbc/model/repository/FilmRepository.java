/**
 * 
 */
package com.arkaitzgarro.jdbc.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arkaitzgarro.jdbc.main.DB;
import com.arkaitzgarro.jdbc.model.Film;
import com.arkaitzgarro.jdbc.model.factory.FilmFactory;

public abstract class FilmRepository {
	private static Connection oconn;

	private FilmRepository() {
		init();
	}

	private static void init() {
		try {
			oconn = DB.getConnection();
		} catch (SQLException e) {
			System.out.println("Unable to connect to DB.");
			e.printStackTrace();
		}
	}

	public void addFilm(Film film) {

	}

	public void removeFilm(Film film) {

	}

	public void updateFilm(Film film) {

	}

	public static Film findOneById(int id) {
		PreparedStatement query;
		ResultSet rs;
		Film film = null;

		init();

		String sql = "SELECT film_id, title, description, release_year FROM film WHERE film_id = ?";

		try {
			// Preparar la consulta
			query = oconn.prepareStatement(sql);
			query.setInt(1, id);

			// Ejecutar la consulta
			rs = query.executeQuery();

			if (rs.next()) {
				film = FilmFactory.create();

				film.setId(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setYear(rs.getByte("release_year"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}
}
