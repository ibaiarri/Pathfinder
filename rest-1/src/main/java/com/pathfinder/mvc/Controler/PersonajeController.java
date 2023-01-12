package com.pathfinder.mvc.Controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pathfinder.model.Personaje;
import com.pathfinder.mvc.Service.PersonajeService;
import com.pathfinder.mvc.Service.PersonajeServiceImpl;

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
	@GetMapping("/lis1")
	public List<Personaje> index() throws Exception {
		return personajeservice.listAllPersonajes();
	}

	
	/**
	 * Lista todos los personajes de un solo jugador
	 * 
	 * @return personajes filtrados por una id
	 * @throws Exception 
	 */
	
	@GetMapping("/lis2")
	public List<Personaje> index1() throws Exception {
		int id =3;
		return personajeservice.listAllPersonajesporID(id);
	}
	
	
	
	
	
}
