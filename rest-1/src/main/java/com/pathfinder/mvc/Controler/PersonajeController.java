package com.pathfinder.mvc.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pathfinder.model.Personaje;
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;
import com.pathfinder.mvc.Service.PersonajeService;

@RestController
@RequestMapping("/api")
public class PersonajeController {

	@Autowired
	private PersonajeService personajeservice;

	
	/**
	 * Lista todos los personajes de la tabla
	 * @return
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lis1")
	public List<Personaje> ListarPersonajes() throws Exception {
		return personajeservice.listAllPersonajes();
	}

	
	
	
	/**
	 * Lista un solo personaje
	 * 
	 * @return personajes filtrados por una id
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lis2")
	public List<Personaje> ListarPersonajesPorID() throws Exception {
		int id =3;
		return personajeservice.listAllPersonajesporID(id);
	}
	
	
	

	
	/**
	 * Lista todos los Usurios de la tabla
	 * @return
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lis3")
	public List<Usuario> ListarUsuarios() throws Exception {
		return personajeservice.listUsuarios();
	}
	

	/**
	 * Lista todos las Razas  de la tabla
	 * @return
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lis4")
	public List<Raza> ListarRazas() throws Exception {
		return personajeservice.listRazas();
	}
	
	/**
	 * Lista Un Usuario por id
	 * @return
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lis5")
	public Usuario ListarUsuariosPorID() throws Exception {
		int id =2;
		return personajeservice.listUsuarioporID(id);
	}
	
	/**
	 * Lista Una Raza por id
	 * @return
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lis6")
	public Raza ListarRazasPorID() throws Exception {
		int id =1;
		return personajeservice.listRazaporID(id);
	}
	/**
	 * Lista todos los personajes de un solo jugador
	 * 
	 * @return personajes filtrados por una id
	 * @throws Exception 
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/lis7")
	public List <Personaje> ListarPersonajesPorIdUsuario() throws Exception {
		int id =2;
		return personajeservice.listPersonajesPorIdUsuario(id);
	}
}
