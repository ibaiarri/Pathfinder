package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pathfinder.dao.PathfinderDaoImp;

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
		
		
		PathfinderDaoImp dao=new PathfinderDaoImp();	
		
		List<com.pathfinder.model.Usuario> usuario = null;
		try {
			usuario = dao.ListUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		usu.setUsuario(request.getParameter("user"));
		usu.setContraseña(request.getParameter("password"));
		
		request.setAttribute("usuario",usu);
		
		
		for(int i=0; i < usuario.size();i++){
			 com.pathfinder.model.Usuario usua=usuario.get(i);
		
			if(usu.getUsuario().equals(usua.getNombre())&&usu.getContraseña().equals(usua.getcontraseña())) {
				
				if (usua.getTipoUser()==1) {
					RequestDispatcher despachador = request.getRequestDispatcher("admin.jsp");
			        despachador.forward(request, response);
				}else {
					RequestDispatcher despachador = request.getRequestDispatcher("user.jsp");
			        despachador.forward(request, response);
				}
		        
		        
			}else { 
				
				//aqui debermeos indicar una pagina de error en la que se indique que los datos no se han encontrado tegno ejemplos en el pc del trabajo
				
			}
		
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doGet(request,response);
		
	}
}
