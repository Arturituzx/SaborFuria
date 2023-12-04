package com.fia.proy.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.proy.model.dao.IContactanosDao;
import com.fia.proy.model.dao.IEmpleadoDao;
import com.fia.proy.model.dao.IFacturaDao;
import com.fia.proy.model.dao.IProductoDao;

import com.fia.proy.model.dao.IReservaDao;
import com.fia.proy.model.entity.Contactanos;
import com.fia.proy.model.entity.Empleado;
import com.fia.proy.model.entity.Factura;
import com.fia.proy.model.entity.Producto;

import com.fia.proy.model.entity.Reserva;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IProductoDao ProductoDao;
	
	@Autowired
	private IReservaDao reservaDao;
	
	@Autowired
	private IContactanosDao contactanosDao;
	
	@Autowired
	private IEmpleadoDao empleadoDao;

	
	// metodos Factura
	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAllFac() {
		// TODO Auto-generated method stub
		return (List<Factura>) facturaDao.findAll();
	}

	@Override
	@Transactional
	public void guardarFac(Factura factura) {
		// TODO Auto-generated method stub
		facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly = true)
	public Factura editarFac(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarFac(Long id) {
		// TODO Auto-generated method stub
		facturaDao.deleteById(id);
	}

	// metodos Producto
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAllProducto() {
		// TODO Auto-generated method stub
		return (List<Producto>) ProductoDao.findAll();
	}

	@Override
	@Transactional
	public void guardarProducto(Producto Producto) {
		// TODO Auto-generated method stub
		ProductoDao.save(Producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto editarProducto(Long id) {
		// TODO Auto-generated method stub
		return ProductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		ProductoDao.deleteById(id);
	}

	// metodos reserva
	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findAllRes() {
		// TODO Auto-generated method stub
		return (List<Reserva>) reservaDao.findAll();
	}

	@Override
	@Transactional
	public void guardarRes(Reserva reserva) {
		// TODO Auto-generated method stub
		reservaDao.save(reserva);
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva editarRes(Long id) {
		// TODO Auto-generated method stub
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarRes(Long id) {
		// TODO Auto-generated method stub
		reservaDao.deleteById(id);
	}

	
	//metodos Contactanos
	@Override
	@Transactional(readOnly = true)
	public List<Contactanos> findAllCon() {
		// TODO Auto-generated method stub
		return (List<Contactanos>) contactanosDao.findAll();
	}

	@Override
	@Transactional
	public void guardarCon(Contactanos contactanos) {
		// TODO Auto-generated method stub
		contactanosDao.save(contactanos);
	}

	@Override
	@Transactional
	public void eliminarCon(Long id) {
		// TODO Auto-generated method stub
		contactanosDao.deleteById(id);
	}
	
	//metodos Empleado
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAllEmp() {
		// TODO Auto-generated method stub
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	@Transactional
	public void guardarEmp(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoDao.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado editarEmp(Long id) {
		// TODO Auto-generated method stub
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarEmp(Long id) {
		// TODO Auto-generated method stub
		empleadoDao.deleteById(id);
	}


	//metodos adicionales
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findHamburguesas() {
	    // Utiliza el método findAllProducto() para obtener todos los productos del menú.
	    List<Producto> todosLosProductos = findAllProducto();

	    List<Producto> hamburguesas = todosLosProductos.stream()
	            .filter(producto -> "Hamburguesas".equals(producto.getTipMe())) 
	            .collect(Collectors.toList());

	    return hamburguesas;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findHelados() {
	    // Utiliza el método findAllProducto() para obtener todos los productos del menú.
	    List<Producto> todosLosProductos = findAllProducto();

	    List<Producto> helados = todosLosProductos.stream()
	            .filter(producto -> "Helados".equals(producto.getTipMe())) 
	            .collect(Collectors.toList());

	    return helados;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findBebidas() {
	    // Utiliza el método findAllProducto() para obtener todos los productos del menú.
	    List<Producto> todosLosProductos = findAllProducto();

	    List<Producto> bebidas = todosLosProductos.stream()
	            .filter(producto -> "Bebidas".equals(producto.getTipMe()))
	            .collect(Collectors.toList());

	    return bebidas;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findComplementos() {
	    // Utiliza el método findAllProducto() para obtener todos los productos del menú.
	    List<Producto> todosLosProductos = findAllProducto();

	 
	    List<Producto> complementos = todosLosProductos.stream()
	            .filter(producto -> "Complementos".equals(producto.getTipMe())) 
	            .collect(Collectors.toList());

	    return complementos;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findPromociones() {

	    List<Producto> todosLosProductos = findAllProducto();

	 
	    List<Producto> promociones = todosLosProductos.stream()
	            .filter(producto -> "Promociones".equals(producto.getTipMe())) 
	            .collect(Collectors.toList());

	    return promociones;
	}


}
