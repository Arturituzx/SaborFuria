package com.fia.proy.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.fia.proy.model.entity.Producto;
import com.fia.proy.model.service.IAdminService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("producto")
public class ProductoController {
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value="/listarProductos",method =RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", adminService.findAllProducto());
		return "frmListaProductos";
	}
	
	@RequestMapping(value="/registrarProducto")
	public String crear(Map<String, Object> model) {
		
		Producto producto=new Producto();
		model.put("producto", producto);
		model.put("titulo", "Formulario de producto");
		return "frmRegistrarProducto";
		
	}
	//guardar imagen
		@RequestMapping(value="/registrarProducto",method=RequestMethod.POST)
		public String guardar(@Valid Producto producto, BindingResult result, Model model, 
				@RequestParam("file") MultipartFile imagen, RedirectAttributes attribute) {
			
			if(result.hasErrors()) {
				model.addAttribute("titulo", "Formulario de Producto");
				model.addAttribute("producto", producto);
				
				attribute.addFlashAttribute("warning", "Existieron errores en el Formulario");
				return "frmRegistrarProducto";
			}
			if(!imagen.isEmpty()) {
				Path directorioImagenes = Paths.get("src//main/resources//static/importar");
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					producto.setImagen(imagen.getOriginalFilename());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			adminService.guardarProducto(producto);
			attribute.addFlashAttribute("success", "Producto guardado");
			return "redirect:/listarProductos";
		}
	
	@RequestMapping(value="/registrarProducto/{id}")
	public String editar(@PathVariable(value="id") Long id,Map<String, Object> model){
		
		Producto producto=null;
		
		if(id>0) {
			producto=adminService.editarProducto(id);
		}else {
			return "redirect:/listarProductos";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar producto");
		return "frmRegistrarProducto";
	}
	
	
	@RequestMapping(value="/eliminarProducto/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id>0) {
			adminService.eliminarProducto(id);
		}
		
		return "redirect:/listarProductos";
	}
	
	@RequestMapping(value="/hamburguesas",method =RequestMethod.GET)
	public String verHamburguesas(Model model) {
	    List<Producto> hamburguesas = adminService.findHamburguesas();
	    model.addAttribute("hamburguesas", hamburguesas);
	    model.addAttribute("titulo", "Hamburguesas");
	    return "frmHamburguesas";
	}
	@RequestMapping(value="/helados",method =RequestMethod.GET)
	public String verHelados(Model model) {
	    List<Producto> helados = adminService.findHelados();
	    model.addAttribute("helados", helados);
	    model.addAttribute("titulo", "Helados");
	    return "frmHelados";
	}
	@RequestMapping(value="/bebidas",method =RequestMethod.GET)
	public String verBebidas(Model model) {
	    List<Producto> bebidas = adminService.findBebidas();
	    model.addAttribute("bebidas", bebidas);
	    model.addAttribute("titulo", "Bebidas");
	    return "frmBebidas";
	}
	@RequestMapping(value="/complementos",method =RequestMethod.GET)
	public String verComplementos(Model model) {
	    List<Producto> complementos = adminService.findComplementos();
	    model.addAttribute("complementos", complementos);
	    model.addAttribute("titulo", "Complementos");
	    return "frmComplementos";
	}
	@RequestMapping(value="/promociones",method =RequestMethod.GET)
	public String verPromociones(Model model) {
	    List<Producto> promociones = adminService.findPromociones();
	    model.addAttribute("promociones", promociones);
	    model.addAttribute("titulo", "promociones");
	    return "frmPromociones";
	}
}
