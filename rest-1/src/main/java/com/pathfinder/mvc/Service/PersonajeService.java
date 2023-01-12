package com.pathfinder.mvc.Service;

import java.util.List;

import com.pathfinder.model.Personaje;





public interface PersonajeService {
	public abstract  List<Personaje> listAllPersonajes() throws Exception;
	public abstract  List<Personaje> listAllPersonajesporID(int id) throws Exception;
	
	
}
