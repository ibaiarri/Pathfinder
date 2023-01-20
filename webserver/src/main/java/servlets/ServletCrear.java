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
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;
//https://coderanch.com/t/629166/java/object-created-servlet-JSP-EL
//https://es.stackoverflow.com/questions/33250/c%C3%B3mo-puedo-guardar-un-objeto-en-la-sesi%C3%B3n-y-c%C3%B3mo-utilizarlo-en-un-jsp-servle


@WebServlet("/ServletCrear")
public class ServletCrear extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Personaje per=new Personaje();
	PathfinderDaoImp dao=new PathfinderDaoImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getParameter("menucrear") != null) {
	
		RequestDispatcher despachador = request.getRequestDispatcher("formulariocreador.jsp");
	    despachador.forward(request, response);
	    
		}else if (request.getParameter("crear") != null){
			try {

				String clase=(request.getParameter("clase"));
				String nombre=(request.getParameter("nombre"));
				int usuario;
				if(request.getParameter("id_usuario")==null) {
					usuario=Integer.parseInt(request.getParameter("usu"));
				}else {
					usuario=Integer.parseInt(request.getParameter("id_usuario"));
				}
				int nivel=Integer.parseInt((request.getParameter("nivel")));
				int raza=Integer.parseInt((request.getParameter("raza")));
				
				Personaje per=new Personaje();
				per.setNombre(nombre);
				per.setClase(clase);
				per.setNivel(nivel);
				
				Usuario usu=dao.ListUsuarioByid(usuario);
				
				per.setUser(usu);
				
				Raza raz=dao.ListRazaByid(raza);
			
				per.setRaza(raz);

		//		List<Usuario> usu=dao.ListUsuarioByid(raza);
		//		for (Raza ra : raz) {
		//			per.setRaza(ra);
		//		}
				
				
				dao.createPersonaje(per);
				if(request.getParameter("id_usuario")==null) {
					RequestDispatcher despachador = request.getRequestDispatcher("admin.jsp");
			        despachador.forward(request, response);
				}else {
					RequestDispatcher despachador = request.getRequestDispatcher("user.jsp");
			        despachador.forward(request, response);
				}
				
		        
		        
		        
		        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (request.getParameter("menucrearusuario") != null){
			int usuario=Integer.parseInt(request.getParameter("id_usuario"));
			request.setAttribute("idusuario",usuario);
			RequestDispatcher despachador = request.getRequestDispatcher("formulariocreador.jsp");
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
