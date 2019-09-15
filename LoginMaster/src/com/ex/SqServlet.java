package com.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SqServlet
 */

public class SqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int k=0;
		
		// 1
	/*
		 k= (int) request.getAttribute("k");
		k=k*k;
		PrintWriter out=response.getWriter();
		out.println("Result is  : " + k);	
	*/
		
		// 2 URL Rewriting
	/*
		k= Integer.parseInt(request.getParameter("k"));
		k=k*k;
		
		PrintWriter out=response.getWriter();
		out.println("Result is  : " + k);	
		*/
		
		//3 Session 
	/*
		HttpSession session = request.getSession();
		
		k= (int) session.getAttribute("sk");
		
		k=k*k;		
		PrintWriter out=response.getWriter();
		out.println("Result is  : " + k);	
	*/	
		 //session.removeAttribute("sk");
		

		
	
		//Cookie
		Cookie cookies[] = request.getCookies();
		
		for(Cookie c: cookies )
		{
			if(c.getName().equals("k"))
				k= Integer.parseInt(c.getValue());
		}
		k=k*k;		
		PrintWriter out=response.getWriter();
		out.println("Result is  : " + k);	
		
		
	}

}
