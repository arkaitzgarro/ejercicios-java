package com.arkaitzgarro.videoclub.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arkaitzgarro.jdbc.model.Film;
import com.arkaitzgarro.jdbc.model.repository.FilmRepository;

/**
 * Servlet implementation class CartController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmRepository filmRepository;

	private final String LIST_NAME = "listFilm";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

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

		String filmId = request.getParameter("film_id");

		RequestDispatcher rd = null;
		HttpSession session = request.getSession(true);

		if (filmId != null) {
			try {
				// Convertir el parametro a nœmero
				long id = Long.parseLong(filmId);

				Film film = filmRepository.findOneById(id);

				if (film != null) {
					List<Film> filmList = (List<Film>) session
							.getAttribute(LIST_NAME);

					if (filmList == null) {
						filmList = new ArrayList<Film>();
					}

					// A–adimos la pelicula a la lista
					filmList.add(film);

					session.setAttribute(LIST_NAME, filmList);

				} else {
					// No existe la pel’cula
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else {
			// No se ha proporcionado un film_id
			response.sendRedirect("/peliculas/listado");
		}
	}
}
