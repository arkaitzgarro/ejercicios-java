package com.arkaitzgarro.videoclub.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arkaitzgarro.jdbc.model.Film;
import com.arkaitzgarro.jdbc.model.repository.FilmRepository;

/**
 * Servlet implementation class FilmViewController
 */
public class FilmViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmRepository filmRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilmViewController() {
		super();
		// TODO Auto-generated constructor stub
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

		if (filmId != null) {
			try {
				// Convertir el parametro a nœmero
				long id = Long.parseLong(filmId);

				Film film = filmRepository.findOneById(id);

				if (film != null) {
					// Mostramos si existe
					request.setAttribute("film", film);

					rd = getServletContext().getRequestDispatcher(
							"/inc/film/view.jsp");
					rd.include(request, response);
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
