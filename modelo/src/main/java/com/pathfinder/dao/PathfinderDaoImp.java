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
	
		
		// Update
		p.setNombre( "DAVID ");
		em.merge(p);		
		em.getTransaction().commit();		
		em.close();
		


	}

	public void DeletePersonaje(int id) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		em.getTransaction().begin();

		// obtener Personaje por Id
		Personaje per = em.find(Personaje.class, id);

		// eliminar
		if (per != null) {
			em.remove(per);
		} else {
			System.out.println("No se puede elimiar un personaje que no existe");
		}

		em.getTransaction().commit();
		em.close();

	}

	public List<Personaje> ListPersonajes() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		final String JPQL = "SELECT p FROM Personaje p";

		ArrayList<Personaje> personaje = (ArrayList<Personaje>) em.createQuery(JPQL).getResultList();
		System.out.println();

		return personaje;

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
	
	public  static PathfinderDaoImp getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new PathfinderDaoImp();
		}
		return INSTANCE;
	}

}
