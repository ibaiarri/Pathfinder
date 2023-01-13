package servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pathfinder.dao.PathfinderDaoImp;
import com.pathfinder.model.Personaje;
//https://coderanch.com/t/629166/java/object-created-servlet-JSP-EL
//https://es.stackoverflow.com/questions/33250/c%C3%B3mo-puedo-guardar-un-objeto-en-la-sesi%C3%B3n-y-c%C3%B3mo-utilizarlo-en-un-jsp-servle
import model.Usuario;

@WebServlet("/ServletEditar")
public class ServletEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PathfinderDaoImp dao=new PathfinderDaoImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		if (request.getParameter("editar") != null || request.getParameter("editarusuario") != null ) {

			try {
				List<Personaje> personajes=dao.ListPersonajeByid(id);
				
				for (Personaje personaje : personajes) {
					request.setAttribute("personaje",personaje);	
					
					RequestDispatcher despachador = request.getRequestDispatcher("formulario.jsp");
				    despachador.forward(request, response);
				    System.out.println(personaje.getNombre());
					
				
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getParameter("eliminar") != null || request.getParameter("eliminarusuario") != null){
			try {
				dao.DeletePersonaje(id);
				
				if (request.getParameter("eliminar") != null) {
					RequestDispatcher despachador = request.getRequestDispatcher("admin.jsp");
			        despachador.forward(request, response);
				}else if(request.getParameter("eliminarusuario") != null ) {
					int usuario=Integer.parseInt(request.getParameter("id_usuario"));
					request.setAttribute("id_usuario",usuario);
					RequestDispatcher despachador = request.getRequestDispatcher("user.jsp");
				    despachador.forward(request, response);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
