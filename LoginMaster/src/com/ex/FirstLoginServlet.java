package com.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.dao.LoginDAO;

/**
 * Servlet implementation class FirstLoginServlet
 * @WebServlet("/FirstLoginServlet")
 */

public class FirstLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("un");
		String pass = request.getParameter("pw");
		
		if (LoginDAO.validate(name, pass)) { //true
			
			//Store in Session
			HttpSession session=request.getSession();
			session.setAttribute("username", name);
			//response.sendRedirect("welcome.jsp");
			
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
			rd.include(request, response);
			out.print("<h1>Sorry username or password error</h1>");
		}
		out.close();

	}

}
