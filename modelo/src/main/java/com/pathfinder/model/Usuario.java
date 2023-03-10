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



@NamedQuery(query = "SELECT usu FROM Usuario usu WHERE usu.nombre = :nombre", name = "find Usuario by name")
@NamedQuery(query = "SELECT usu FROM Usuario usu WHERE usu.id_usuario = :id_usuario", name = "find Usuario by id")
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@NotNull
	private int id_usuario;

	@Column(unique = true)
	@Size(min = 2, max = 20, message = "El apellido del personaje debe estar entre 2 y 20 caracteres")
	@NotEmpty
	private String nombre;

	@NotEmpty
	@Size(min = 2, max = 20, message = "El apellido del personaje debe estar entre 2 y 20 caracteres")
	private String apellido;

	private int tef;
	
	private String contraseña;

	//0 cuando indica 0 es usuario y 1 es administrador
	private int tipoUser;
	@OneToMany
	private Set<Personaje> personajes;

	public Usuario() {
		super();
		this.id_usuario = 0;
		this.nombre = "";
		this.apellido = "";
		this.tef = 0;
		this.tipoUser = 1;
		this.contraseña="";
		this.personajes = new HashSet<Personaje>();
	}

	public Usuario(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Usuario(int id, String nombre) {
		this();
		this.id_usuario = 0;
		this.nombre = nombre;
	}

	public Usuario(String nombre, String apellido, int tef) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tef = tef;
		this.tipoUser = 0;
		;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTef() {
		return tef;
	}

	public void setTef(int tef) {
		this.tef = tef;
	}

	public int getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}

	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}
	
	public String getcontraseña() {
		return contraseña;
	}

	public void setcontraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", tef=" + tef
				+ ", tipoUser=" + tipoUser + ", personajes=" + personajes + "]";
	}

	

	

}
