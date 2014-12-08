package com.arkaitzgarro.session.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COUNT_KEY = "COUNT_KEY";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		/**
		 * Crear un objeto HttpSesson si no existe
		 */
		HttpSession session = request.getSession(true);

		Integer count = (Integer) session.getAttribute(COUNT_KEY);
		if (count == null) {
			count = new Integer(0);
		}

		count = new Integer(count.intValue() + 1);
		session.setAttribute(COUNT_KEY, count);

		out.println("Session ID: " + session.getId());
		out.println("Reloads: " + count.intValue());

		out.println("SESSION DATA");

		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();

			out.println(name + " = " + session.getAttribute(name));
		}

		if (count.intValue() == 5) {
			session.invalidate();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

}
