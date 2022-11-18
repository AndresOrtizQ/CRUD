package com.prueba.tecnica.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ocupaciones")

public class Ocupacion  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ocu;

	@Column(name = "nombre_ocupacion", length = 20)
	private String nombre_ocupacion;

	
	public Ocupacion() {
		super();
	}

	public Ocupacion(Long id_ocu, String nombre_ocupacion) {
		super();
		this.id_ocu = id_ocu;
		this.nombre_ocupacion = nombre_ocupacion;
	}

	public Long getId_ocu() {
		return id_ocu;
	}

	public void setId_ocu(Long id_ocu) {
		this.id_ocu = id_ocu;
	}

	public String getNombre_ocupacion() {
		return nombre_ocupacion;
	}

	public void setNombre_ocupacion(String nombre_ocupacion) {
		this.nombre_ocupacion = nombre_ocupacion;
	}

	
}
