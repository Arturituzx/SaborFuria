package com.fia.proy.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.proy.model.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

}
