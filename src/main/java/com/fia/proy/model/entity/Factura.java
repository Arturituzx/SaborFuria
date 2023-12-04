package com.fia.proy.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="facturas")
public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_Factura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFac;
	
	@Column(name="fecha_Emision")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecEm;
	
	private String descripcion, observacion;
	
	private String ruc;
	
	@Column(name="razon_Social")
	private String razSoc;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="factura_id")
	public List<ItemFactura> items;
	
	public Factura() {
		this.items = new ArrayList<ItemFactura>();
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	@PrePersist
	public void fechaCre() {
		fecEm= new Date();
	}

	public Long getIdFac() {
		return idFac;
	}

	public void setIdFac(Long idFac) {
		this.idFac = idFac;
	}

	public Date getFecEm() {
		return fecEm;
	}

	public void setFecEm(Date fecEm) {
		this.fecEm = fecEm;
	}

	

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazSoc() {
		return razSoc;
	}

	public void setRazSoc(String razSoc) {
		this.razSoc = razSoc;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public double getTotal() {
		double total=0.0;
		
		int size=items.size();
		
		for(int i=0;i<size;i++) {
			total +=items.get(i).calcularImporte();
		}
		
		return total;
	}
	

}
