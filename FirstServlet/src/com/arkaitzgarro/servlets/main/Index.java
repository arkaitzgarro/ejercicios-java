package com.arkaitzgarro.servlets.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Iniciar variables para este servlet
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// MŽtodo que procesa la petici—n GET a /index
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("Hello World!");

		out.println("Server:\t\t" + request.getServerName() + ":"
				+ request.getServerPort());
		out.print("Client:\t\t" + request.getRemoteHost());
		out.println("\t" + request.getRemoteAddr());
		out.println("Protocol:\t" + request.getProtocol());

		Enumeration<String> params = request.getParameterNames();
		if (params != null) {
			while (params.hasMoreElements()) {
				String param = (String) params.nextElement();
				String value = request.getParameter(param);
				out.println(param + "\t=\t" + value);
			}
		}
	}
}
