package com.duoc.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 1, message = "Nombre Requerido")
	@Size(max = 50, message = "Máximo 50 carácteres")
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Size(min = 1, message = "Apellido Requerido")
	@Size(max = 50, message = "Máximo 50 carácteres")
	@Column(name = "apellido", length = 50, nullable = false)
	private String apellido;
	
	@Email
	@Size(min = 1, message = "Email Requerido")
	@Size(max = 50, message = "Máximo 50 carácteres")
	@Column(name = "Email", length = 50, nullable = false)
	private String email;
	
	@ManyToOne
	@NotNull
	private Carrera carrera;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the carrera
	 */
	public Carrera getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", carrera=" + carrera + "]";
	}
}
