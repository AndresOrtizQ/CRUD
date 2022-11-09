package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "canchas")

public class Cancha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cancha;

	@Column(name = "nombre_cancha", length = 10)
	private String nombre_cancha;
	
	public Cancha() {
	}

	public Cancha(String nombre_cancha) {
		super();
		this.nombre_cancha = nombre_cancha;
	}

	public Long getId_cancha() {
		return id_cancha;
	}

	public void setId_cancha(Long id_cancha) {
		this.id_cancha = id_cancha;
	}

	public String getNombre_cancha() {
		return nombre_cancha;
	}

	public void setNombre_cancha(String nombre_cancha) {
		this.nombre_cancha = nombre_cancha;
	}

}
