package com.arkaitzgarro.session.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String admin = "admin";
	private final String password = "password";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Obtener usuario y contrase–a
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		if (admin.equals(user) && password.equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("logged", "Arkaitz Garro");

			// Tiempo m‡ximo de sesi—n
			session.setMaxInactiveInterval(30 * 60);

			String encodedURL = response.encodeRedirectURL("login-success.jsp");
			response.sendRedirect(encodedURL);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/login.jsp");

			request.setAttribute("error", "login_error");
			request.setAttribute("user", user);
			rd.include(request, response);
		}
	}
}
