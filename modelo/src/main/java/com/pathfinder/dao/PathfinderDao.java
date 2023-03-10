package com.pathfinder.dao;

import java.util.List;

import com.pathfinder.model.Personaje;
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;

public interface PathfinderDao {

	public void createPersonaje(Personaje personaje) throws Exception;

	public void modificarPersonaje(Personaje personaje) throws Exception;

	public void DeletePersonaje(int id) throws Exception;

	public List<Personaje> ListPersonajes() throws Exception;

	public List<Personaje> ListPersonajeByid(int id) throws Exception;

	public List<Usuario> ListUsuario() throws Exception;
	
	public List<Raza> ListRaza() throws Exception;
	
	public Usuario ListUsuarioByid(int id) throws Exception;
	
	public int UsuarioFilterByName(String nombre) throws Exception;
	
	public Raza ListRazaByid(int id) throws Exception;


}
