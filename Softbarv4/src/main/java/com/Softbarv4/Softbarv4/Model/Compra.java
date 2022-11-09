package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "compras")

public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_compra")
	private Date fecha_compra;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "total")
	private int total;

	@OneToOne
	@JoinColumn(name = "id_proveedor_fk" )
	private Proveedor id_proveedor_fk;
	
	public Compra() {
	}

	public Compra(Date fecha_compra, int cantidad, int total, Proveedor id_proveedor_fk) {
		super();
		this.fecha_compra = fecha_compra;
		this.cantidad = cantidad;
		this.total = total;
		this.id_proveedor_fk = id_proveedor_fk;
	}

	public Long getId_compra() {
		return id_compra;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Proveedor getId_proveedor_fk() {
		return id_proveedor_fk;
	}

	public void setId_proveedor_fk(Proveedor id_proveedor_fk) {
		this.id_proveedor_fk = id_proveedor_fk;
	}

}
