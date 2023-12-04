package com.fia.proy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.proy.model.dao.IClienteDao;
import com.fia.proy.model.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findCliente() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente editarCliente(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean validarUsuario(String correo, String contrasena) {
	    // Busca al cliente por correo utilizando el método definido en el repositorio
	    Cliente cliente = clienteDao.findByCorreo(correo);
	    
	    // Verifica si el cliente existe y si la contraseña coincide
	    if (cliente != null && cliente.getContra().equals(contrasena)) {
	        return true; // El usuario y la contraseña son válidos
	    }
	    
	    return false; // Usuario o contraseña incorrectos
	}
}
