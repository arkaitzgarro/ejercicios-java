package com.arkaitzgarro.jdbc.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.arkaitzgarro.jdbc.db.DataBaseHelper;
import com.arkaitzgarro.jdbc.model.Film;

public class FilmRepository {
	private DataBaseHelper dbHelper;

	public FilmRepository() throws SQLException {
		dbHelper = new DataBaseHelper();
	}

	/**
	 * Buscar todas las peliculas de la base de datos
	 * 
	 * @return
	 */
	public List<Film> findAll() {
		List<Film> list = new ArrayList<Film>();
		String sql = "SELECT film_id, title, description, release_year FROM film;";

		ResultSet rows = dbHelper.query(sql);
		try {
			if (rows != null) {
				while (rows.next()) {
					Film film = new Film();
					film.setId(rows.getLong("film_id"));
					film.setTitle(rows.getString("title"));
					film.setDescription(rows.getString("description"));
					film.setYear(rows.getDate("release_year"));

					list.add(film);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Busca una pelicula por ID
	 * 
	 * @param id
	 * @return
	 */
	public Film findOneById(long id) {
		Film film = null;

		String sql = "SELECT * FROM film  WHERE film_id = ?;";
		PreparedStatement query = dbHelper.queryPrepared(sql);

		try {
			if (query != null) {
				query.setLong(1, id);

				ResultSet row = query.executeQuery();

				if (row != null && row.next()) {
					film = new Film();
					film.setId(row.getLong("film_id"));
					film.setTitle(row.getString("title"));
					film.setDescription(row.getString("description"));
					film.setYear(row.getDate("release_year"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	/**
	 * Insertar una pelicula en la base de datos
	 * 
	 * @param film
	 * @return
	 */
	public boolean insert(Film film) {

		String insert = "INSERT INTO film(title, description, release_year, language_id)"
				+ " VALUES(?, ?, ?, 1);";

		Calendar cal = Calendar.getInstance();
		PreparedStatement query = dbHelper.queryPrepared(insert);

		try {
			if (query != null) {
				query.setString(1, film.getTitle());
				query.setString(2, film.getDescription());
				query.setString(3, String.valueOf(cal.get(Calendar.YEAR)));

				int rows = query.executeUpdate();

				if (rows == 1) {
					ResultSet generatedKeys = query.getGeneratedKeys();
					if (generatedKeys.next()) {
						film.setId((int) generatedKeys.getLong(1));

						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Update an existing film
	 * 
	 * @param film
	 * @return
	 */
	public boolean update(Film film) {
		Calendar cal = Calendar.getInstance();

		String sql = "UPDATE film"
				+ " SET title=?, description=?, release_year=?"
				+ " WHERE film_id=?";

		// Preparar la consulta
		PreparedStatement query = dbHelper.queryPrepared(sql);

		try {
			if (query != null) {
				query.setString(1, film.getTitle());
				query.setString(2, film.getDescription());

				query.setString(3, String.valueOf(cal.get(Calendar.YEAR)));
				query.setLong(4, film.getId());

				int rows = query.executeUpdate();

				return rows == 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Remove a film from DB
	 * 
	 * @param film
	 * @return
	 */
	public boolean delete(Film film) {
		String sql = "DELETE FROM film WHERE film_id = ?";

		try {
			PreparedStatement query = dbHelper.queryPrepared(sql);

			query.setLong(1, film.getId());

			int rows = query.executeUpdate();

			return rows == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
