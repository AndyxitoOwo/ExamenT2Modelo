package com.t2Valdivia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.t2Valdivia.utils.Alert;
import com.t2Valdivia.dto.ResultadoResponse;
import com.t2Valdivia.models.Inventario;
import com.t2Valdivia.models.Producto;
import com.t2Valdivia.repositories.IInventarioRepository;
import com.t2Valdivia.repositories.IProductoRepository;
import com.t2Valdivia.services.InventarioServices;
import com.t2Valdivia.services.ProductoServices;

@Controller
@RequestMapping("/inventario")
public class InventarioController {
	@Autowired
	private InventarioServices inventarioService;
	
	@Autowired
	private ProductoServices productoService;
	
	
	@GetMapping("/listadoValdivia")
	public String listado(Model model) {
		List<Inventario> getInventario = inventarioService.getAll();
		model.addAttribute("lstInventario",getInventario);
		return "inventario/listadoValdivia";
	}
	
	@GetMapping("/crear")
	public String crearInventario(Model model) {
		model.addAttribute("lstProducto", productoService.getAll());
		Inventario i = new Inventario();
		i.setFechaVencimiento(LocalDate.now());
		model.addAttribute("inventario", i);
		return "inventario/crearValdivia";
	}
	
	@PostMapping("/registrar")
	public String registrarInventario(@ModelAttribute Inventario inventario,Model model,RedirectAttributes flash) {
		ResultadoResponse response = inventarioService.createInventario(inventario);		
		if(!response.success) {
			model.addAttribute("lstProducto", productoService.getAll());
			flash.addFlashAttribute("alerta", Alert.sweetAlertError(response.mensaje));
			return "inventario/listadoValdivia";

		}
		flash.addFlashAttribute("alerta", Alert.sweetAlertSuccess(response.mensaje));
		return "redirect:/inventario/listadoValdivia";
	}
	
	@GetMapping("/editar/{id}")
	public String editarInventario(@PathVariable int id, Model model) {
		model.addAttribute("lstProducto", productoService.getAll());
		Inventario inventario = inventarioService.getOne(id);
		model.addAttribute("inventario", inventario);
		return "inventario/actualizarValdivia";
	}
	
	@PostMapping("/actualizar")
	public String actualizarInventario(@ModelAttribute Inventario inventario,Model model,RedirectAttributes flash) {
		ResultadoResponse response = inventarioService.actualizarInventario(inventario);		
		if(!response.success) {
			model.addAttribute("lstProducto", productoService.getAll());
			flash.addFlashAttribute("alerta", Alert.sweetAlertError(response.mensaje));
			return "inventario/listadoValdivia";
		}
		flash.addFlashAttribute("alerta", Alert.sweetAlertSuccess(response.mensaje));
		return "redirect:/inventario/listadoValdivia";
	}
}
