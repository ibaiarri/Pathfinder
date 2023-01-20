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


	public void createPersonaje(Personaje personaje) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		em.getTransaction().begin();

		em.persist(personaje);

		em.getTransaction().commit();

	}

	public void modificarPersonaje(Personaje p) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		
		em.getTransaction().begin();		

		em.merge(p);		
		em.getTransaction().commit();		
		em.close();

	}

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

	public List<Personaje> ListPersonajes() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		final String JPQL =  "SELECT p FROM Personaje p where p.disponible = 1";

		ArrayList<Personaje> personaje = (ArrayList<Personaje>) em.createQuery(JPQL).getResultList();
		System.out.println();

		return personaje;

	}
	
	public List<Raza> ListRaza() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();

		final String JPQL = "SELECT r FROM Raza r";

		ArrayList<Raza> raza = (ArrayList<Raza>) em.createQuery(JPQL).getResultList();
		System.out.println();

		return raza;

	}

	public List<Personaje> ListPersonajeByid(int id) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		Query query = em.createNamedQuery("find Personaje by id");
		query.setParameter("id_personaje", id);

		List<Personaje> personajes = query.getResultList();

		return personajes;
	}
	
	
	public List<Personaje> ListPersonajeByUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		Query query = em.createNamedQuery("find Personaje by idUsuario");
		query.setParameter("id_usuario", id);

		List<Personaje> personajes = query.getResultList();

		return personajes;
	}
	
	
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
	

	public Raza ListRazaByid(int id) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("find Raza by id");
		query.setParameter("id_raza", id);

		Raza raza = (Raza) query.getSingleResult();

		return raza;
	}
	
	public Usuario ListUsuarioByid(int id) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();	

		Query query = em.createNamedQuery("find Usuario by id");
		query.setParameter("id_usuario", id);

		Usuario usuario = (Usuario) query.getSingleResult();

		return usuario;
	}
	
	public List<Usuario> ListUsuario() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		final String JPQL = "SELECT u FROM Usuario u ";

		ArrayList<Usuario> usuario = (ArrayList<Usuario>) em.createQuery(JPQL).getResultList();
		System.out.println();

		return usuario;
	}

	public  static PathfinderDaoImp getInstance() {
		
	
		if(INSTANCE==null) {
			INSTANCE=new PathfinderDaoImp();
		}
		return INSTANCE;

	}

}
