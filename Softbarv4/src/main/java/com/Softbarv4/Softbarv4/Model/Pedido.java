package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido;

	@Column(name = "precio")
	private int precio;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "total")
	private int total;

	@OneToOne
	@JoinColumn(name = "id_usuario_fk")
	private Usuario id_usuario_fk;

	@ManyToOne
	@JoinColumn(name = "id_productos_fk")
	private Producto id_productos_fk;

	public Pedido() {
	}

	public Pedido(int precio, int cantidad, int total, Usuario id_usuario_fk, Producto id_productos_fk) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
		this.id_usuario_fk = id_usuario_fk;
		this.id_productos_fk = id_productos_fk;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
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

	public Usuario getId_usuario_fk() {
		return id_usuario_fk;
	}

	public void setId_usuario_fk(Usuario id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}

	public Producto getId_productos_fk() {
		return id_productos_fk;
	}

	public void setId_productos_fk(Producto id_productos_fk) {
		this.id_productos_fk = id_productos_fk;
	}

}
