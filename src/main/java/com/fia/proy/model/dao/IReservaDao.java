package com.fia.proy.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.proy.model.entity.Reserva;

public interface IReservaDao extends CrudRepository<Reserva, Long> {

}
