package com.sena.evaluacion.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;
	private String password;
	private String telefono;
	private Date fecharegistro;
	
	@OneToMany(mappedBy = "usuario")
	private List<Cita> citas;
	
	@OneToMany(mappedBy = "usuario")
	private List<Profesional> profesionales;
	
	//metodo contructor vacío
	public Usuario() {
		
	}

	//metodo contructor con campos
	public Usuario(Integer id, String nombre, String email, String password, String telefono, Date fecharegistro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.fecharegistro = fecharegistro;
	}

	//metodo get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	//metodo toString
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password
				+ ", telefono=" + telefono + ", fecharegistro=" + fecharegistro + "]";
	}

}
