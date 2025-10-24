package com.sena.evaluacion.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesionales")
public class Profesional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String especialidad;
	private Date horariodisponible;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "profesional")
	private List<Cita> citas;
	
	//metodo contructor vacío
	public Profesional() {
		
	}

	//metodo contructor con campos 
	public Profesional(Integer id, String especialidad, Date horariodisponible) {
		super();
		this.id = id;
		this.especialidad = especialidad;
		this.horariodisponible = horariodisponible;
	}
	
	//metodo get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getHorariodisponible() {
		return horariodisponible;
	}

	public void setHorariodisponible(Date horariodisponible) {
		this.horariodisponible = horariodisponible;
	}

	//metodo toString
	@Override
	public String toString() {
		return "Profesional [id=" + id + ", especialidad=" + especialidad + ", horariodisponible=" + horariodisponible
				+ "]";
	}
	
	
}

