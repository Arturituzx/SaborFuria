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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fia.proy.model.entity.Cliente;
import com.fia.proy.model.service.IClienteService;

import jakarta.validation.Valid;

@Controller
public class ClienteController {

	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value="/listarClientes",method =RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findCliente());
		return "frmListaClientes";
	}
	
	@RequestMapping(value="/registrarCliente")
	public String crear(Map<String, Object> model) {
		
		Cliente cliente=new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario del Cliente");
		return "frmRegistrarCliente";
		
	}
	
	@RequestMapping(value="/registrarCliente",method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Cliente");
			return "frmRegistrarCliente";
		}
		
		clienteService.saveCliente(cliente);
		return "redirect:login";
	}
	
	@RequestMapping(value="/registrarCliente/{id}")
	public String editar(@PathVariable(value="id") Long id,Map<String, Object> model){
		
		Cliente cliente=null;
		
		if(id>0) {
			cliente = clienteService.editarCliente(id);
		}else {
			return "redirect:/listarClientes";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "frmRegistrarCliente";
	}
	
	@RequestMapping(value="/eliminarCliente/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			clienteService.eliminarCliente(id);
		}
		
		return "redirect:/listarClientes";
	}
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id, Map<String,Object> model,RedirectAttributes flash) {
		
		Cliente cliente= clienteService.editarCliente(id);
		
		if(cliente==null) {
			flash.addFlashAttribute("error", "El cliente noexiste en la base de datos");
			return "redirect:/listar";
		}
		
		model.put("cliente", cliente);
		model.put("titulo", "Detalle del cliente: "+cliente.getNom());
		
		return "verCliente";
	}
}
