package com.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectDB
 */

public class SelectDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		String docType = "<!doctype html>\n";

		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body>");
		try {
			// Register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Open a connection
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "system", "faith");

			// Execute SQL query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM tblUser";
			rs = stmt.executeQuery(sql);
			out.println("<table border=1 >");
			out.println("<caption><h2>User Record</h2></caption>");

			out.println("<tr style='background-color:#ffffb3; color:red'>");
			out.println("<th>User Id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Password</th>");
			out.println("<th>Age</th>");
			out.println("</tr>");
			
			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String uname = rs.getString("name");
				String pass = rs.getString("password");
				int age = rs.getInt("age");
				
				// Display values
				out.println("<tr style='background-color:#b3ffd9;'>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + uname + "</td>");
				out.println("<td>" + pass + "</td>");
				out.println("<td>" + age + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");

			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
