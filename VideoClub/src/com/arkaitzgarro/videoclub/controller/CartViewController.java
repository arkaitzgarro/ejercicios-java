package com.arkaitzgarro.videoclub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arkaitzgarro.videoclub.model.Film;

/**
 * Servlet implementation class CartViewController
 */
public class CartViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartViewController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		List<Film> listFilm = (List<Film>) session
				.getAttribute(CartController.LIST_NAME);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/inc/cart/list.jsp");

		request.setAttribute("list", listFilm);
		rd.include(request, response);
	}

}
