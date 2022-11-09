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
@Table(name = "domicilios")

public class Domicilio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_domicilio;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha")
	private Date fecha;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(iso = ISO.TIME)
	@Column(name = "hora")
	private Date hora;

	@Column(name = "estado", length = 50)
	private String Estado;

	@OneToOne
	@JoinColumn(name = "id_pedido_fk")
	private Pedido id_pedido_fk;

	public Domicilio() {
	}

	public Domicilio(Date fecha, Date hora, String estado, Pedido id_pedido_fk) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		Estado = estado;
		this.id_pedido_fk = id_pedido_fk;
	}

	public Long getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(Long id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Pedido getId_pedido_fk() {
		return id_pedido_fk;
	}

	public void setId_pedido_fk(Pedido id_pedido_fk) {
		this.id_pedido_fk = id_pedido_fk;
	}

}
