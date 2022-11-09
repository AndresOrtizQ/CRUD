package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proveedor;

	@Column(name = "nombre_proveedor", length = 50)
	private String nombre_proveedor;

	@Column(name = "articulo", length = 100)
	private String articulo;

	public Proveedor() {
	}

	public Proveedor(String nombre_proveedor, String articulo) {
		super();
		this.nombre_proveedor = nombre_proveedor;
		this.articulo = articulo;
	}

	public Long getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

}
