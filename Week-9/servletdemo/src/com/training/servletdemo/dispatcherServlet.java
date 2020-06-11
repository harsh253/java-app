package com.training.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dispatcherServlet
 */

@WebServlet("/dispatcherServlet")
public class dispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getPathInfo();
		
		switch(url) {
		case "/getEmps":
		{
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			out.println("<body><html>");
			out.println("<h4>All Employees</h4>");
			out.println("</body></html>");
		}
			break;
			
		case "/getCustomer":
			{
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				
				out.println("<body><html>");
				out.println("<h4>All Customers</h4>");
				out.println("</body></html>");
			}
			break;
			
		case "/getProducts":
			{
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				
				out.println("<body><html>");
				out.println("<h4>All Products</h4>");
				out.println("</body></html>");
			}
			break;
			
			default:
			{
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				
				out.println("<body><html>");
				out.println("<h4>Invalid URL</h4>");
				out.println("</body></html>");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
