package com.fia.proy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fia.proy.model.entity.Empleado;
import com.fia.proy.model.service.IAdminService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("factura")
public class EmpleadoController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value="/listarEmpleados",method =RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Empleados");
		model.addAttribute("empleados", adminService.findAllEmp());
		return "frmListaEmpleados";
	}
	
	@RequestMapping(value="/registrarEmpleado")
	public String crear(Map<String, Object> model) {
		
		Empleado empleado=new Empleado();
		model.put("empleado", empleado);
		model.put("titulo", "Formulario de Empleado");
		return "frmRegistrarEmpleado";
		
	}
	
	@RequestMapping(value="/registrarEmpleado",method=RequestMethod.POST)
	public String guardar(@Valid Empleado empleado, BindingResult result, Model model,SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Empleado");
			return "frmRegistrarEmpleado";
		}
		
		adminService.guardarEmp(empleado);
		status.setComplete();
		return "redirect:listarEmpleados";
	}
	
	@RequestMapping(value="/registrarEmpleado/{id}")
	public String editar(@PathVariable(value="id") Long id,Map<String, Object> model){
		
		Empleado empleado=null;
		
		if(id>0) {
			empleado=adminService.editarEmp(id);
		}else {
			return "redirect:/listarEmpleados";
		}
		model.put("empleado", empleado);
		model.put("titulo", "Editar Empleado");
		return "frmRegistrarEmpleado";
	}
	
	@RequestMapping(value="/eliminarEmpleado/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			adminService.eliminarEmp(id);
		}
		
		return "redirect:/listarEmpleados";
	}
}
