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

@WebServlet("/ServerConDatosIndex")
public class ServerConDatosIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
       Usuario usu=new Usuario();
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerConDatosIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String usuario = null;
		String password=null;
		

		usu.setUsuario(request.getParameter("user"));
		usu.setContraseña(request.getParameter("password"));
		
		
		
		if(usuario.equals("admin")||password.equals("123")) {
	          RequestDispatcher despachador = request.getRequestDispatcher("/scripts/admin.jsp");
              despachador.forward(request, response);
		}else {
			PrintWriter salida=response.getWriter();
			salida.println("<html><meta charset=\"UTF-8\"/><body>");
			salida.println("Usuario incorrecto");		
			salida.println("</body></html>");
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
