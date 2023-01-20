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
import javax.servlet.http.HttpSession;

import com.pathfinder.dao.PathfinderDaoImp;
import com.pathfinder.model.Usuario;


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
		boolean comprobar = false;
		
		PathfinderDaoImp dao=new PathfinderDaoImp();	
		
		List<com.pathfinder.model.Usuario> usuario = null;
		try {
			usuario = dao.ListUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int id;
		try {
			id = dao.UsuarioFilterByName(request.getParameter("user"));
			usu.setId_usuario(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		usu.setNombre(request.getParameter("user"));
		usu.setcontraseña(request.getParameter("password"));
		
		


		    HttpSession sesion = request.getSession(true);
		   

		   
		    sesion.setAttribute("usuario",usu);
		
		
		for(int i=0; i < usuario.size();i++){
			 com.pathfinder.model.Usuario usua=usuario.get(i);
		
			if(usu.getNombre().equals(usua.getNombre())&& usu.getcontraseña().equals(usua.getcontraseña())) {
				comprobar=true;
				if (usua.getTipoUser()==1) {
					RequestDispatcher despachador = request.getRequestDispatcher("admin.jsp");
			        despachador.forward(request, response);
				}else if (usua.getTipoUser()==0){
					RequestDispatcher despachador = request.getRequestDispatcher("user.jsp");
			        despachador.forward(request, response);
				}
		        
		        
			}
		
		}
		if(comprobar==false) {
			//aqui debermeos indicar una pagina de error en la que se indique que los datos no se han encontrado tegno ejemplos en el pc del trabajo
			PrintWriter salida=response.getWriter();
			
			salida.println("<html><body>");
			salida.println("<p>El usuario introducido no existe</p>");
			salida.println("<form method='get' action='/webserver'>");
			salida.println("<button type='submit'>inicio");
			salida.println("</form>");
			salida.println("</body></html>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doGet(request,response);
		
	}
}
