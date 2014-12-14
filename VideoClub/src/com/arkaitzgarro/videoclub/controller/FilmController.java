package com.arkaitzgarro.videoclub.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arkaitzgarro.jdbc.model.Film;
import com.arkaitzgarro.jdbc.model.repository.FilmRepository;
import com.google.gson.Gson;

/**
 * Servlet implementation class PeliculaListado
 */
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Gson gson;
	private FilmRepository filmRepository;

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
		super.init(config);

		gson = new Gson();

		// Iniciar variables para este servlet
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

		String format = request.getParameter("format");
		List<Film> listFilm = filmRepository.findAll();

		if (format != null && format.equals("json")) {
			response.setContentType("text/json");
			response.getWriter().print(gson.toJson(listFilm));
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/inc/film/list.jsp");

			request.setAttribute("list", listFilm);
			rd.include(request, response);
		}
	}
}
