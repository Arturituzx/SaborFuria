package com.fia.proy.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.proy.model.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

	Cliente findByCorreo(String correo);
}
