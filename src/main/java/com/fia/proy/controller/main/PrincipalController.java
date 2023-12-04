package com.fia.proy.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fia.proy.model.entity.Producto;
import com.fia.proy.model.service.IAdminService;
import com.fia.proy.model.service.IClienteService;

@Controller
public class PrincipalController {
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IClienteService clienteService;

	private static final String adminUser = "SFUser@saborfuria.com";
	private static final String adminPass = "Usmp2023";

	@RequestMapping(value = "/")
	public String inicio(Model model) {
		List<Producto> promociones = adminService.findPromociones();
	    model.addAttribute("promociones", promociones);
	    model.addAttribute("titulo", "promociones");
		return "frmInicio";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "frmLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String correo, @RequestParam String contra, RedirectAttributes redirAttrs) {
		if (correo.equalsIgnoreCase(adminUser) && contra.equalsIgnoreCase(adminPass)) {
			return "redirect:/menuAdmin";
		} else {
			if(clienteService.validarUsuario(correo, contra)) {
				return "redirect:/";
			}else {
				return "redirect:/login";
			}
		}
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		return "frmMenus";
	}

	@RequestMapping(value = "/menuAdmin", method = RequestMethod.GET)
	public String getMenuAdmin(Model model) {
		return "frmMenuAdmin";
	}

	@RequestMapping(value = "/nosotros", method = RequestMethod.GET)
	public String nosotros(Model model) {
		return "frmNosotros";
	}

	@RequestMapping(value = "/tips", method = RequestMethod.GET)
	public String tips(Model model) {
		return "frmTips";
	}

}