package com.ex;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 @WebServlet("/WelcomeServlet")
*/
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**cfgf
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("un");
		out.print("Welcome " + username);
		out.close();
		*/
		
		response.sendRedirect("welcome.jsp");
		
		
	}
	
	
}
