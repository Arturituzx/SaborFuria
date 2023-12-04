package com.fia.proy.model.service;

import java.util.List;

import com.fia.proy.model.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findCliente();

	public void saveCliente(Cliente cliente);

	public Cliente editarCliente(Long id);

	public void eliminarCliente(Long id);
	
	// Nuevo método para validar el usuario por correo y contraseña
    public boolean validarUsuario(String correo, String contrasena);
}
