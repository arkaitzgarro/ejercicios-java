/**
 * 
 */
package com.arkaitzgarro.rest.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.arkaitzgarro.rest.db.DB;
import com.arkaitzgarro.rest.model.Film;
import com.arkaitzgarro.rest.model.factory.FilmFactory;
import com.mysql.jdbc.Statement;

public abstract class FilmRepository {
	private static Connection oconn;

	private FilmRepository() throws ClassNotFoundException, SQLException {
		init();
	}

	/**
	 * Get database connection
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void init() throws ClassNotFoundException, SQLException {
		oconn = DB.getConnection();
	}

	/**
	 * Insert a new film into DB
	 * 
	 * @param film
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean addFilm(Film film) throws ClassNotFoundException,
			SQLException {
		PreparedStatement ins = null;
		Calendar cal = Calendar.getInstance();

		init();

		String sql = "INSERT INTO film(title, description, release_year, language_id)"
				+ " VALUES(?,?,?,?)";

		try {
			// Preparar la consulta
			ins = oconn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// Completar los datos
			ins.setString(1, film.getTitle());
			ins.setString(2, film.getDescription());

			cal.setTime(film.getYear());
			ins.setString(3, String.valueOf(cal.get(Calendar.YEAR)));
			ins.setInt(4, 1);

			int rows = ins.executeUpdate();

			if (rows == 1) {
				ResultSet generatedKeys = ins.getGeneratedKeys();
				if (generatedKeys.next()) {
					film.setId((int) generatedKeys.getLong(1));

					return true;
				}
			}

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(ins.toString());

			return false;
		}
	}

	/**
	 * Remove a film with given ID
	 * 
	 * @param id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean removeFilm(int id) throws ClassNotFoundException,
			SQLException {
		Film film = findOneById(id);

		return removeFilm(film);
	}

	/**
	 * Remove a film from DB
	 * 
	 * @param film
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean removeFilm(Film film) throws ClassNotFoundException,
			SQLException {
		PreparedStatement ins = null;

		init();

		String sql = "DELETE FROM film WHERE film_id = ?";

		try {
			// Preparar la consulta
			ins = oconn.prepareStatement(sql);

			// Completar los datos
			ins.setInt(1, film.getId());

			int rows = ins.executeUpdate();

			return rows == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(ins.toString());

			return false;
		}
	}

	/**
	 * Update an existing film
	 * 
	 * @param film
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean updateFilm(Film film) throws ClassNotFoundException,
			SQLException {
		PreparedStatement ins = null;
		Calendar cal = Calendar.getInstance();

		init();

		String sql = "UPDATE film"
				+ " SET title=?, description=?, release_year=?"
				+ " WHERE film_id=?";

		try {
			// Preparar la consulta
			ins = oconn.prepareStatement(sql);

			// Completar los datos
			ins.setString(1, film.getTitle());
			ins.setString(2, film.getDescription());

			cal.setTime(film.getYear());
			ins.setString(3, String.valueOf(cal.get(Calendar.YEAR)));
			ins.setInt(4, film.getId());

			int rows = ins.executeUpdate();

			return rows == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(ins.toString());

			return false;
		}
	}

	/**
	 * Find one film by given ID
	 * 
	 * @param id
	 * @return Film
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Film findOneById(int id) throws ClassNotFoundException,
			SQLException {
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
				film.setYear(rs.getDate("release_year"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	public static List<Film> findAll() throws ClassNotFoundException,
			SQLException {
		PreparedStatement query;
		ResultSet rs;
		Film film = null;
		List<Film> list = new ArrayList<Film>();

		init();

		String sql = "SELECT film_id, title, description, release_year FROM film";

		try {
			// Preparar la consulta
			query = oconn.prepareStatement(sql);

			// Ejecutar la consulta
			rs = query.executeQuery();

			while (rs.next()) {
				film = FilmFactory.create();

				film.setId(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setYear(rs.getDate("release_year"));

				list.add(film);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
