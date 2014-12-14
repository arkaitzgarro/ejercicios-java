package com.arkaitzgarro.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arkaitzgarro.jdbc.model.factory.FilmFactory;
import com.arkaitzgarro.jdbc.model.interfaces.IFilm;
import com.arkaitzgarro.jdbc.model.repository.FilmRepository;
import com.google.gson.Gson;

/**
 * Servlet implementation class FilmController
 */
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Gson gson;
	private static FilmFactory filmFactory;
	private static FilmRepository filmRepository;

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
		filmFactory = new FilmFactory();

		try {
			filmRepository = new FilmRepository();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getMethod().equals("HEAD")) {
			return;
		}

		PrintWriter out = response.getWriter();
		List<IFilm> list = null;

		// String param = UriMatcher.getType(request.getRequestURI());
		// if (param == UriMatcher.ALL_ROWS) {}
		String format = request.getParameter("format");

		format = (format != null) ? format : "html";

		// Devolver un listado con todas las pel’culas
		if (filmRepository != null) {
			list = filmRepository.findAll();
		}

		if (format.equals("json")) {
			response.setContentType("text/json");
			out.print(gson.toJson(list));
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/inc/film-list.jsp");

			request.setAttribute("list", list);
			rd.include(request, response);
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
		IFilm film = filmFactory.create();
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));

		try {
			film.setYear(sdf.parse(request.getParameter("year")));
		} catch (ParseException e) {
			e.printStackTrace();
			film.setYear(new Date());
		}

		if (filmRepository != null) {
			filmRepository.insert(film);
			out.print(gson.toJson(film));
		} else {
			out.print(gson.toJson(null));
		}
	}

	/**
	 * Mostrar todas las filas d ela base de datos.
	 * 
	 * @param out
	 */
	private void printAllRows(PrintWriter out) {
		List<IFilm> list = null;

		// Devolver un listado con todas las pel’culas
		if (filmRepository != null) {
			list = filmRepository.findAll();
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
		IFilm film = null;

		// Devolver un listado con todas las pel’culas
		if (filmRepository != null) {
			film = filmRepository.findOneById(id);
		}

		out.print(gson.toJson(film));
	}

}
