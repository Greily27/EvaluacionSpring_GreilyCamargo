package com.sena.evaluacion.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fechahora;
	private String estado;
	
	@ManyToOne
	private Servicio servicio;
	
	@ManyToOne
	private Profesional profesional;
	
	@ManyToOne
	private Usuario usuario;

	//metodo contructor sin campos 
	public Cita() {
	}

	//metodo constructor con campos 
	public Cita(Integer id, Date fechahora, String estado, Servicio servicio, Profesional profesional,
			Usuario usuario) {
		super();
		this.id = id;
		this.fechahora = fechahora;
		this.estado = estado;
		this.servicio = servicio;
		this.profesional = profesional;
		this.usuario = usuario;
	}

	//metodo get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechahora() {
		return fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//metodo toString
	@Override
	public String toString() {
		return "Cita [id=" + id + ", fechahora=" + fechahora + ", estado=" + estado + ", servicio=" + servicio
				+ ", profesional=" + profesional + ", usuario=" + usuario + "]";
	}
	
	
	
}
