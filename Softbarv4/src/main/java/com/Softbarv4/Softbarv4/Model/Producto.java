package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;

	@Column(name = "nombre_producto")
	private String nombre_producto;

	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria id_categoria;

	@ManyToMany
	@JoinTable(name = "Detalle_Compra", joinColumns = @JoinColumn(name = "id_producto", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_compra", nullable = false))
	private List<Compra> listCompras;

	@OneToMany(mappedBy = "id_producto_fk")
	private List<Inventario> ListaPro;

	@OneToMany(mappedBy = "id_productos_fk")
	private List<Pedido> ListaProd;

	public Producto() {
	}

	public Producto(String nombre_producto, Categoria id_categoria) {
		super();
		this.nombre_producto = nombre_producto;
		this.id_categoria = id_categoria;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Categoria getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}

}
