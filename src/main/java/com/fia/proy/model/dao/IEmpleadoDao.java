package com.fia.proy.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.fia.proy.model.entity.Empleado;

public interface IEmpleadoDao  extends CrudRepository<Empleado, Long>{

}
