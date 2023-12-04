package com.fia.proy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fia.proy.model.entity.Cliente;
import com.fia.proy.model.entity.Factura;
import com.fia.proy.model.service.IAdminService;
import com.fia.proy.model.service.IClienteService;

import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("factura")
public class FacturaController {
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value="/listarFacturas",method =RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Facturas");
		model.addAttribute("facturas", adminService.findAllFac());
		return "frmListaFacturas";
	}
	
	@RequestMapping(value="/registrarFactura")
	public String crear(Map<String, Object> model) {
		
		Factura factura=new Factura();
		model.put("factura", factura);
		model.put("titulo", "Formulario de Factura");
		return "frmRegistrarFactura";
		
	}
	
	@RequestMapping(value="/registrarFactura",method=RequestMethod.POST)
	public String guardar(@Valid Factura factura, BindingResult result, Model model,SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Factura");
			return "frmRegistrarFactura";
		}
		
		adminService.guardarFac(factura);
		status.setComplete();
		return "redirect:listarFacturas";
	}
	
	@RequestMapping(value="/registrarFactura/{id}")
	public String editar(@PathVariable(value="id") Long id,Map<String, Object> model){
		
		Factura factura=null;
		
		if(id>0) {
			factura=adminService.editarFac(id);
		}else {
			return "redirect:/listarFacturas";
		}
		model.put("factura", factura);
		model.put("titulo", "Editar Factura");
		return "frmRegistrarFactura";
	}
	
	@RequestMapping(value="/eliminarFactura/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			adminService.eliminarFac(id);
		}
		
		return "redirect:/listarFacturas";
	}
	
	@GetMapping(value="/registrarFacturas/{clienteId}")
	public String crear(@PathVariable(value="clienteId") Long clienteId,
						Map<String, Object> model,
						RedirectAttributes flash) {
		
		Cliente cliente=clienteService.editarCliente(clienteId);
		if(cliente==null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		Factura factura=new Factura();
		factura.setCliente(cliente);
		
		model.put("factura", factura);
		model.put("titulo", "Crear Factura");
				
		return "/Facturas/Factura";
	}
}
