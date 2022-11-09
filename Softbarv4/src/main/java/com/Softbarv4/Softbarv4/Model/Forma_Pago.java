package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formas_pago")

public class Forma_Pago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_forma_pago;

	@Column(name = "nombre_Formas", length = 30)
	private String nombre_formas;
	

	public Forma_Pago() {
	}

	public Forma_Pago(String nombre_formas) {
		super();
		this.nombre_formas = nombre_formas;
	}

	public Long getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(Long id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public String getNombre_formas() {
		return nombre_formas;
	}

	public void setNombre_formas(String nombre_formas) {
		this.nombre_formas = nombre_formas;
	}

}
