package com.pathfinder.dao;

import java.util.List;

import com.pathfinder.model.Personaje;

public interface PathfinderDao {

	public void createPersonaje(Personaje personaje) throws Exception;

	public void modificarPersonaje(Personaje personaje) throws Exception;

	public void DeletePersonaje(int id) throws Exception;

	public List<Personaje> ListPersonajes() throws Exception;

	public List<Personaje> ListPersonajeByid(int id) throws Exception;
	
	

}
