package com.pathfinder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pathfinder.model.Personaje;
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;

public class ListarPersonajeConUsuarios {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		
		Raza raza1 = new Raza("humano");
		Usuario usuario1 = new Usuario("Ramon", "castrejo", 692716076);
		Personaje personaje1 = new Personaje("Elen",raza1 , 1, "mago", usuario1);
		Personaje personaje2 = new Personaje("Grack",raza1, 1, "sorcerer", usuario1);
		em.persist(raza1);
		em.persist(usuario1);
		em.persist(personaje1);
		em.persist(personaje2);

		em.getTransaction().commit();
		em.close();
	}

}
