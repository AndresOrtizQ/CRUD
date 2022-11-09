package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "inventarios")

public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_inventario;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_ingreso")
	private Date fecha_ingreso;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_vencimiento")
	private Date fecha_vencimiento;

	@Column(name = "cantidad_existente")
	private int cantidad_existente;

	@Column(name = "nota")
	private String nota;

	@ManyToOne
	@JoinColumn(name = "id_producto_fk")
	private Producto id_producto_fk;

	public Inventario() {
	}

	public Inventario(Date fecha_ingreso, Date fecha_vencimiento, int cantidad_existente, String nota,
			Producto id_producto_fk) {
		super();
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_vencimiento = fecha_vencimiento;
		this.cantidad_existente = cantidad_existente;
		this.nota = nota;
		this.id_producto_fk = id_producto_fk;
	}

	public Long getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Long id_inventario) {
		this.id_inventario = id_inventario;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public int getCantidad_existente() {
		return cantidad_existente;
	}

	public void setCantidad_existente(int cantidad_existente) {
		this.cantidad_existente = cantidad_existente;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Producto getId_producto_fk() {
		return id_producto_fk;
	}

	public void setId_producto_fk(Producto id_producto_fk) {
		this.id_producto_fk = id_producto_fk;
	}

}
