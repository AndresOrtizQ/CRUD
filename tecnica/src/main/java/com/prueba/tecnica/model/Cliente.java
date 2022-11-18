package com.prueba.tecnica.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "clientes")

public class Cliente {


	@Id
	private Long identificacion;

	@Column(name = "Nombre", length = 30)
	private String nombre;

	@Column(name = "Apellido", length = 30)
	private String apellido;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name = "Correo", length = 50)
	private String correo;

	@Column(name = "telefono", length = 10)
	private String telefono;

	@OneToOne
	@JoinColumn(name = "id_ocupacion")
	private Ocupacion id_ocupacion;
	
	@OneToOne
	@JoinColumn(name = "id_ciudad")
	private Ciudad id_ciudad;

	public Cliente() {
		super();
	}

	public Cliente(Long identificacion, String nombre, String apellido, Date fecha_nacimiento, String correo,
			String telefono, Ocupacion id_ocupacion, Ciudad id_ciudad) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.correo = correo;
		this.telefono = telefono;
		this.id_ocupacion = id_ocupacion;
		this.id_ciudad = id_ciudad;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ocupacion getId_ocupacion() {
		return id_ocupacion;
	}

	public void setId_ocupacion(Ocupacion id_ocupacion) {
		this.id_ocupacion = id_ocupacion;
	}

	public Ciudad getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Ciudad id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	

}
