package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="venta_Reservas")

public class Venta_Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta_reserva;
	
	@Column(name="valor_total")
	private int valor_total;
	
	@ManyToMany
	@JoinTable(name="Pago_Reservas",
	joinColumns= @JoinColumn (name="id_venta_reserva", nullable=false),
	inverseJoinColumns=@JoinColumn(name="id_forma_pago", nullable=false))
	private List<Forma_Pago> listFormas;

	public Venta_Reserva(int valor_total) {
		super();
		this.valor_total = valor_total;
	}

	public Long getId_venta_reserva() {
		return id_venta_reserva;
	}

	public void setId_venta_reserva(Long id_venta_reserva) {
		this.id_venta_reserva = id_venta_reserva;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}
}
