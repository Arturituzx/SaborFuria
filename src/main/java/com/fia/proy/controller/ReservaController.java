package com.fia.proy.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.fia.proy.model.entity.Reserva;
import com.fia.proy.model.service.IAdminService;
import org.springframework.web.bind.support.SessionStatus;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("reserva")
public class ReservaController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value="/listarReservas",method =RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Reservas");
		model.addAttribute("reservas", adminService.findAllRes());
		return "frmListaReservas";
	}
	
	@RequestMapping(value="/Reserva")
	public String crear(Map<String, Object> model) {
		
		Reserva reserva=new Reserva();
		model.put("reserva", reserva);
		model.put("titulo", "Formulario de Reserva");
		return "frmReserva";
		
	}
	
	@RequestMapping(value="/Reserva",method=RequestMethod.POST)
	public String guardar(@Valid Reserva reserva, BindingResult result, Model model,SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Reserva");
			return "frmReserva";
		}
		
		adminService.guardarRes(reserva);
		status.setComplete();
		return "redirect:/Reserva";
	}
	
}
