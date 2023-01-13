package com.pathfinder.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pathfinder.model.Personaje;
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;

public class Menu {

	public static void main(String[] args) throws Exception {
//		listID();
		listartod();
		 //eliminar();
		//crear();
		//update();
		//listarRaza();
	}

	
	private static void crear() throws Exception {
		PathfinderDaoImp imp = new PathfinderDaoImp();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();	
		
		Raza raza = em.find(Raza.class,1);
		Usuario user = em.find(Usuario.class,2);
		
		Personaje per = new Personaje("Elen",raza , 1, "mago",user);
		imp.createPersonaje(per);
		
		
	}

	private static void eliminar() throws Exception {
		PathfinderDaoImp imp = new PathfinderDaoImp();
		imp.DeletePersonaje(4);

	}

	public static void listID() throws Exception {
		PathfinderDaoImp imp = new PathfinderDaoImp();
		int id = 3;
		List<Personaje> personajes = imp.ListPersonajeByid(id);

		for (Personaje personaje : personajes) {
			System.out.print(personaje);
		}

	}

	public static void listartod() throws Exception {
		PathfinderDaoImp imp = new PathfinderDaoImp();
		List<Personaje> per = imp.ListPersonajes();

		System.out.println("Los personajes son los siguientes:");
		System.out.println(per);
	}
	
	
	private static void update() throws Exception{
		PathfinderDaoImp imp = new PathfinderDaoImp();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();	
		
		Personaje personaje = em.find(Personaje.class,7);
		imp.modificarPersonaje(personaje);
	}
	
	public static void listarRaza() throws Exception {
		PathfinderDaoImp imp = new PathfinderDaoImp();
		List<Raza> ra = imp.ListRaza();

		System.out.println("Los personajes son los siguientes:");
		System.out.println(ra);
	}

}
