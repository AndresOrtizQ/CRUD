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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta_domicilios")

public class Venta_Domicilio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta_domicilios;

	@Column(name = "valor_total")
	private int valor_total;

	@OneToOne
	@JoinColumn(name = "id_domicilio_fk")
	private Domicilio id_domicilio_fk;

	@ManyToMany
	@JoinTable(name = "Pago_Domicilios", joinColumns = @JoinColumn(name = "id_venta_domicilio", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_forma_pago", nullable = false))
	private List<Forma_Pago> listFormas;

	public Venta_Domicilio() {
	}

	public Venta_Domicilio(int valor_total, Domicilio id_domicilio_fk) {
		super();
		this.valor_total = valor_total;
		this.id_domicilio_fk = id_domicilio_fk;
	}

	public Long getId_venta_domicilios() {
		return id_venta_domicilios;
	}

	public void setId_venta_domicilios(Long id_venta_domicilios) {
		this.id_venta_domicilios = id_venta_domicilios;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	public Domicilio getId_domicilio_fk() {
		return id_domicilio_fk;
	}

	public void setId_domicilio_fk(Domicilio id_domicilio_fk) {
		this.id_domicilio_fk = id_domicilio_fk;
	}

}
