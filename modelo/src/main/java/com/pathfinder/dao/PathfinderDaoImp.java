package com.pathfinder.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.pathfinder.model.Personaje;
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;


public class PathfinderDaoImp implements PathfinderDao  {
	private static PathfinderDaoImp INSTANCE=null;

	/**
	 * Cargamos los datos obtenidos del objeto personaje en la db
	 */



	public void createPersonaje(Personaje personaje) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		em.getTransaction().begin();

		em.persist(personaje);

		em.getTransaction().commit();

	}
	/**
	 * modificamos la db con los datos obtenidos del objeto personaje
	 */
	
	public void modificarPersonaje(Personaje p) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		
		em.getTransaction().begin();		

		em.merge(p);		
		em.getTransaction().commit();		
		em.close();

	}
	/**
	 * Hace un borrado lógico de la fila personaje seleccionado  
	 * modificando el campo disponible de la base de datos a 0
	 * 
	 */
	public void DeletePersonaje(int id) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		em.getTransaction().begin();

		
		// obtener Personaje por Id
		Personaje p = em.find(Personaje.class, id);
		p.setDisponible(0);
		em.merge(p);		
		em.getTransaction().commit();		
		em.close();
	
	}
	
	/**
	 * Lista los diferentes personajes obtenidos de la base de datos
	 */
	public List<Personaje> ListPersonajes() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		final String JPQL =  "SELECT p FROM Personaje p where p.disponible = 1";

		ArrayList<Personaje> personaje = (ArrayList<Personaje>) em.createQuery(JPQL).getResultList();
		System.out.println();

		return personaje;

	}
	
	/**
	 * Lista las diferentes razas obtenidas de la base de datos
	 */
	
	public List<Raza> ListRaza() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();

		final String JPQL = "SELECT r FROM Raza r";

		ArrayList<Raza> raza = (ArrayList<Raza>) em.createQuery(JPQL).getResultList();
		System.out.println();

		return raza;

	}
	
	/**
	 * Lista los diferentes personajes obtenidos de la base de datos filtrando por id
	 */

	public List<Personaje> ListPersonajeByid(int id) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		Query query = em.createNamedQuery("find Personaje by id");
		query.setParameter("id_personaje", id);

		List<Personaje> personajes = query.getResultList();

		return personajes;
	}
	
	
	/**
	 * Lista los diferentes personajes obtenidos de la base de datos filtrando por id el id del Usuario
	 */
	
	public List<Personaje> ListPersonajeByUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		Query query = em.createNamedQuery("find Personaje by idUsuario");
		query.setParameter("id_usuario", id);

		List<Personaje> personajes = query.getResultList();

		return personajes;
	}
	
	/**
	 * Lista los diferentes Usuarios obtenidos de la base de datos filtrando por nombre del usuario
	 */
	
	
	public int UsuarioFilterByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		Query query = em.createNamedQuery("find Usuario by name");
		query.setParameter("nombre", nombre);

		Usuario usuario = (Usuario) query.getSingleResult();
		int id=usuario.getId_usuario();

		return id;
	}
	
	/**
	 * Lista las diferentes razas obtenidas de la base de datos filtrando por el id
	 */
	

	public Raza ListRazaByid(int id) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("find Raza by id");
		query.setParameter("id_raza", id);

		Raza raza = (Raza) query.getSingleResult();

		return raza;
	}
	
	/**
	 * Lista los diferentes Usuarios obtenidos de la base de datos filtrando por id
	 */
	
	public Usuario ListUsuarioByid(int id) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();	

		Query query = em.createNamedQuery("find Usuario by id");
		query.setParameter("id_usuario", id);

		Usuario usuario = (Usuario) query.getSingleResult();

		return usuario;
	}
	
	/**
	 * Lista los diferentes Usuarios obtenidos de la base de datos 
	 */
	
	public List<Usuario> ListUsuario() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		final String JPQL = "SELECT u FROM Usuario u ";

		ArrayList<Usuario> usuario = (ArrayList<Usuario>) em.createQuery(JPQL).getResultList();
		System.out.println();

		return usuario;
	}

	/**
	 * Aqui se instancia la implementacion del dao
	 */
	
	
	public  static PathfinderDaoImp getInstance() {
		
	
		if(INSTANCE==null) {
			INSTANCE=new PathfinderDaoImp();
		}
		return INSTANCE;

	}

}
