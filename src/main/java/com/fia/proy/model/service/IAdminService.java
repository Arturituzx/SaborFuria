package com.fia.proy.model.service;

import java.util.List;

import com.fia.proy.model.entity.Contactanos;
import com.fia.proy.model.entity.Empleado;
import com.fia.proy.model.entity.Factura;
import com.fia.proy.model.entity.Producto;

import com.fia.proy.model.entity.Reserva;

public interface IAdminService {

	// primera lista Facturas
	public List<Factura> findAllFac();

	public void guardarFac(Factura factura);

	public Factura editarFac(Long id);

	public void eliminarFac(Long id);

	// segunda lista Menu
	public List<Producto> findAllProducto();

	public void guardarProducto(Producto menu);

	public Producto editarProducto(Long id);

	public void eliminarProducto(Long id);

	// tercera lista Reserva
	public List<Reserva> findAllRes();

	public void guardarRes(Reserva reserva);

	public Reserva editarRes(Long id);

	public void eliminarRes(Long id);

	// cuarta lista contactanos
	
	public List<Contactanos> findAllCon();

	public void guardarCon(Contactanos contactanos);
	
	public void eliminarCon(Long id);
	
	// quinta lista Empleado
	
	public List<Empleado> findAllEmp();

	public void guardarEmp(Empleado empleado);

	public Empleado editarEmp(Long id);

	public void eliminarEmp(Long id);
	
	
	
	//filtro
	public List<Producto> findHamburguesas();
	
	public List<Producto> findHelados();
	
	public List<Producto> findBebidas();
	
	public List<Producto> findComplementos();
	
	public List<Producto> findPromociones();


}
