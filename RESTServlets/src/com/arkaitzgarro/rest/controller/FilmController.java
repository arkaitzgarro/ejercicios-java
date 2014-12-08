package com.arkaitzgarro.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arkaitzgarro.rest.model.Film;
import com.arkaitzgarro.rest.model.factory.FilmFactory;
import com.arkaitzgarro.rest.model.repository.FilmRepository;
import com.google.gson.Gson;

/**
 * Servlet implementation class FilmController
 */
@WebServlet("/film/*")
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Gson gson;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilmController() {
		super();

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Iniciar variables para este servlet
		gson = new Gson();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getMethod().equals("HEAD"))
			return;

		response.setContentType("text/json");
		PrintWriter out = response.getWriter();

		String param = UriMatcher.getType(request.getRequestURI());

		if (param == UriMatcher.ALL_ROWS) {
			printAllRows(out);
		} else {
			printOneRow(UriMatcher.getId(), out);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/json");
		PrintWriter out = response.getWriter();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		// Obtener los datos por POST y a–adir una nueva pel’cula
		Film film = FilmFactory.create();
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));

		try {
			film.setYear(sdf.parse(request.getParameter("year")));
		} catch (ParseException e) {
			e.printStackTrace();
			film.setYear(new Date());
		}

		try {
			FilmRepository.addFilm(film);
		} catch (ClassNotFoundException e) {
			out.print("Error de conexi—n con la BD");
			System.exit(0);
		} catch (SQLException e) {
			out.print("Error de conexi—n con la BD");
			System.exit(0);
		}

		out.print(gson.toJson(film));
	}

	/**
	 * Mostrar todas las filas d ela base de datos.
	 * 
	 * @param out
	 */
	private void printAllRows(PrintWriter out) {
		List<Film> list = null;
		try {
			// Devolver un listado con todas las pel’culas
			list = FilmRepository.findAll();
		} catch (ClassNotFoundException e) {
			out.print("Error de conexi—n con la BD");
			System.exit(0);
		} catch (SQLException e) {
			out.print("Error de conexi—n con la BD");
			System.exit(0);
		}

		out.print(gson.toJson(list));
	}

	/**
	 * Mostrar un registro de la base de datos
	 * 
	 * @param id
	 * @param out
	 */
	private void printOneRow(int id, PrintWriter out) {
		Film film = null;
		try {
			// Devolver un listado con todas las pel’culas
			film = FilmRepository.findOneById(id);
		} catch (ClassNotFoundException e) {
			out.print("Error de conexi—n con la BD");
			System.exit(0);
		} catch (SQLException e) {
			out.print("Error de conexi—n con la BD");
			System.exit(0);
		}

		out.print(gson.toJson(film));
	}

}
