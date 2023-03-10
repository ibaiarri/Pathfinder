
package com.pathfinder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pathfinder.dao.PathfinderDaoImp;

@Entity // @Entity define que la entidad es persistible contra la base de datos

@NamedQuery(query = "SELECT per FROM Personaje per WHERE per.user.id_usuario = :id_usuario And per.disponible = 1", name = "find Personaje by idUsuario")
@NamedQuery(query = "SELECT per FROM Personaje per WHERE per.id_personaje = :id_personaje  And per.disponible = 1", name = "find Personaje by id")

public class Personaje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_personaje;

	@NotEmpty
	@Size(min = 2, max = 20, message = "El nombre del personaje debe  estar entre 2 y 20 caracteres")
	private String nombre;


	@NotNull
	private int nivel;

	@NotEmpty
	private String clase;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	@Valid // SIRVE PARA VALIDAR EN CASCADA CUENTA SE VALIDA ESTE OBJETO
	private Usuario user;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_raza", nullable = false)
	@Valid 
	private Raza raza;
	
	
	@NotNull
	private int disponible;
	
	public Personaje() {
		super();
		this.id_personaje = 0;
		this.nombre = "";
		this.raza = new Raza();
		this.nivel = 0;
		this.clase = "";
		this.user = new Usuario();
		this.disponible = 1;
	}

	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	
	public Personaje(int id) {
		this();
		this.id_personaje = id;
	}

	public Personaje(String nombre, Raza raza, int nivel, String clase, Usuario user) {
		this();
		this.nombre = nombre;
		this.raza = raza;
		this.nivel = nivel;
		this.clase= clase;
		this.user = user;
		this.disponible = 1;
	}
	
	public Personaje(String nombre, int raza, int nivel, String clase, int user) {
		this();
		this.nombre = nombre;
		this.nivel = nivel;
		this.clase= clase;
		this.disponible = 1;
	}

	public int getId_personaje() {
		return id_personaje;
	}

	public void setId_personaje(int id_personaje) {
		this.id_personaje = id_personaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Personaje [id_personaje=" + id_personaje + ", nombre=" + nombre + ", nivel=" + nivel + ", clase="
				+ clase + ", user=" + user + ", raza=" + raza + ", disponible=" + disponible + "]";
	}


	

	


}
