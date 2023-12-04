package com.fia.proy.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="productos")
public class Producto implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imagen;
	
	@NotEmpty
	@Column(name="tipo_Menu")
	private String tipMe;
	
	@NotEmpty
	@Column(name="nombre_Menu")
	private String nomMen;
	

	@NotNull
	@Column(name="precio")
	private double pre;
	
	@Column(name="fecha_Creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecCre;
	
	@PrePersist
	public void fechaCre() {
		fecCre=new Date();
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipMe() {
		return tipMe;
	}

	public void setTipMe(String tipMe) {
		this.tipMe = tipMe;
	}

	public String getNomMen() {
		return nomMen;
	}

	public void setNomMen(String nomMen) {
		this.nomMen = nomMen;
	}

	
	public double getPre() {
		return pre;
	}


	public void setPre(double pre) {
		this.pre = pre;
	}


	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
}
