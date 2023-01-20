package com.pathfinder.mvc.Service;

import java.util.List;

import com.pathfinder.model.Personaje;
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;

public interface PersonajeService {
	public abstract List<Personaje> listAllPersonajes() throws Exception;

	public abstract Personaje listAllPersonajesporID(int id) throws Exception;
	
	public abstract Personaje listPersonajesPorIdUsuario(int id) throws Exception;
	
	public abstract List<Usuario> listUsuarios() throws Exception;
	
	public abstract Usuario listUsuarioporID(int id) throws Exception;

	public abstract List<Raza> listRazas() throws Exception;
	
	public abstract Raza listRazaporID(int id) throws Exception;


}
