package com.fia.proy.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.proy.model.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

}
