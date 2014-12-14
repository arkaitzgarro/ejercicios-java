package com.arkaitzgarro.videoclub.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arkaitzgarro.jdbc.model.interfaces.IFilm;
import com.arkaitzgarro.jdbc.model.repository.FilmRepository;

/**
 * Servlet implementation class CartDeleteController
 */
public class CartDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmRepository filmRepository;

	public static final String LIST_NAME = "listFilm";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartDeleteController() {
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

		HttpSession session = request.getSession(true);

		if (filmId != null) {
			try {
				// Convertir el parametro a nœmero
				long id = Long.parseLong(filmId);

				List<IFilm> filmList = (List<IFilm>) session
						.getAttribute(LIST_NAME);

				if (filmList != null) {
					for (int i = 0; i < filmList.size(); i++) {
						IFilm film = filmList.get(0);

						if (film.getId() == id) {
							filmList.remove(i);
						}
					}
				}

				response.sendRedirect(request.getContextPath() + "/carro/ver");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else {
			// No se ha proporcionado un film_id
			response.sendRedirect(request.getContextPath()
					+ "/peliculas/listado");
		}
	}
}
