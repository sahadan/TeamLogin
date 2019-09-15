package com.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int i= Integer.parseInt(request.getParameter("num1"));
		int j= Integer.parseInt(request.getParameter("num2"));
		
		int k=i+j;
		System.out.println("Result is "+ k);	
		
		// 1
		/*
		PrintWriter out=response.getWriter();
		out.println("Result is "+ k);	
		*/
		
		//2
		/*
		request.setAttribute("k", k);
		
		RequestDispatcher rd = request.getRequestDispatcher("sq") ;
		rd.forward(request, response);
		
	*/
		
		
		
		// 3 URL Rewriting
		//response.sendRedirect("sq");	
			
		//response.sendRedirect("sq?k=" + k);			//URL Rewriting
		
		
		
		
		// 4 Session
	/*
		HttpSession session = request.getSession();
		session.setAttribute("sk", k);
		
		response.sendRedirect("sq");	
	
	*/	
		// 5 Cookie
	
		Cookie cookie= new Cookie("k", k+ "");
		response.addCookie(cookie);
		
		response.sendRedirect("sq");	
		
		
	}

}
