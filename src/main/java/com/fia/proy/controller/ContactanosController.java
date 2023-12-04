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

import com.fia.proy.model.entity.Contactanos;
import com.fia.proy.model.service.IAdminService;
import org.springframework.web.bind.support.SessionStatus;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("contactanos")
public class ContactanosController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value="/listarContactanos",method =RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Contactanos");
		model.addAttribute("contactanos", adminService.findAllCon());
		return "frmListaContactanos";
	}
	
	@RequestMapping(value="/Contactanos")
	public String crear(Map<String, Object> model) {
		
		Contactanos contactanos=new Contactanos();
		model.put("contactanos", contactanos);
		model.put("titulo", "Formulario de Contactanos");
		return "frmContactanos";
		
	}
	
	@RequestMapping(value="/Contactanos",method=RequestMethod.POST)
	public String guardar(@Valid Contactanos contactanos, BindingResult result, Model model,SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Contactanos");
			return "frmContactanos";
		}
		
		adminService.guardarCon(contactanos);
		status.setComplete();
		return "redirect:/Contactanos";
	}
	
	@RequestMapping(value="/eliminarContactanos/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			adminService.eliminarCon(id);
		}
		
		return "redirect:/listarContactanos";
	}
}
