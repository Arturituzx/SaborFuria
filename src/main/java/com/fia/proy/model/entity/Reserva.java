package com.fia.proy.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reservas")
public class Reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id_Reserva")
	private Long idRes;
	
	@Column(name="numero_mesa")
	private String numMe;
	

	@Column(name="numero_Personas")
	private String numPer;
	

	@Column(name="fecha_reservacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecRes;
	

	@Column(name="hora_reservacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date horRes;

	public Long getIdRes() {
		return idRes;
	}

	public void setIdRes(Long idRes) {
		this.idRes = idRes;
	}

	public String getNumMe() {
		return numMe;
	}

	public void setNumMe(String numMe) {
		this.numMe = numMe;
	}

	public String getNumPer() {
		return numPer;
	}

	public void setNumPer(String numPer) {
		this.numPer = numPer;
	}

	public Date getFecRes() {
		return fecRes;
	}

	public void setFecRes(Date fecRes) {
		this.fecRes = fecRes;
	}

	public Date getHorRes() {
		return horRes;
	}

	public void setHorRes(Date horRes) {
		this.horRes = horRes;
	}

		
	
}
