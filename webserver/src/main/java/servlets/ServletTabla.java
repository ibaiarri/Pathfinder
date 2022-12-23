package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pathfinder.model.Personaje;
//https://coderanch.com/t/629166/java/object-created-servlet-JSP-EL
//https://es.stackoverflow.com/questions/33250/c%C3%B3mo-puedo-guardar-un-objeto-en-la-sesi%C3%B3n-y-c%C3%B3mo-utilizarlo-en-un-jsp-servle
import model.Usuario;

@WebServlet("/ServletLectura")
public class ServletTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Personaje per=new Personaje();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTabla() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String per=request.getParameter("per");
		request.setAttribute("persona",per);
		RequestDispatcher despachador = request.getRequestDispatcher("formulario.jsp");
	    despachador.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doGet(request,response);
		
	}
}
