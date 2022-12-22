package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet("/ServletLectura")
public class ServletLectura extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usu=new Usuario();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLectura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		usu.setUsuario(request.getParameter("user"));
		usu.setContraseña(request.getParameter("password"));
		
		request.setAttribute("usuario",usu);
		
		if(usu.getUsuario().equals("admin")&&usu.getContraseña().equals("123")) {
			RequestDispatcher despachador = request.getRequestDispatcher("admin.jsp");
	        despachador.forward(request, response);
		}else { 
			RequestDispatcher despachador = request.getRequestDispatcher("user.jsp");
	        despachador.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doGet(request,response);
		
	}
}
