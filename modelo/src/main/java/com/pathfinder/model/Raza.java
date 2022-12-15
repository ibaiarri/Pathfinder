package com.pathfinder.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;

@Entity
public class Raza implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@NotNull
	private int id_raza;

	@Column(unique = true)
	@Size(min = 2, max = 20, message = "El apellido del personaje debe estar entre 2 y 20 caracteres")
	@NotEmpty
	private String nombre;

	@OneToMany
	private Set<Personaje> personajes;

	public Raza(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Raza(int id, String nombre) {
		this();
		this.id_raza = 0;
		this.nombre = nombre;
	}

	public Raza(String nombre, String apellido,Set<Personaje> personajes) {
		super();
		this.nombre = nombre;		
		this.personajes = new HashSet<Personaje>();
	}

	public Raza() {
		super();
		this.id_raza = 0;
		this.nombre = "";
		this.personajes = new HashSet<Personaje>();
	}

	public int getId_raza() {
		return id_raza;
	}

	public void setId_raza(int id_raza) {
		this.id_raza = id_raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "Raza [id_raza=" + id_raza + ", nombre=" + nombre + ", personajes=" + personajes + "]";
	}


	
	

}
