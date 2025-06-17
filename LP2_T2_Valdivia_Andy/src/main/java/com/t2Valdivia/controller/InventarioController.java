package com.t2Valdivia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.t2Valdivia.utils.Alert;
import com.t2Valdivia.models.Inventario;
import com.t2Valdivia.repositories.IInventarioRepository;
import com.t2Valdivia.repositories.IProductoRepository;

@Controller
public class InventarioController {
	@Autowired
	private IInventarioRepository _inventarioRepo;
	
	@Autowired
	private IProductoRepository _producoRepo;
	
	
	@GetMapping("/listadoValdivia")
	public String listado(Model model) {
		model.addAttribute("lstInventario",_inventarioRepo.findAllByOrderByNumeroDesc());
		return "listadoValdivia";
	}
	
	@GetMapping("/crear")
	public String crearInventario(Model model) {
		model.addAttribute("lstProducto", _producoRepo.findAll());
		model.addAttribute("inventario", new Inventario());
		return "crearValdivia";
	}
	
	@PostMapping("/registrar")
	public String registrarInventario(@ModelAttribute Inventario inventario,Model model,RedirectAttributes flash) {
		model.addAttribute("lstProducto", _producoRepo.findAll());
		Inventario registrado = _inventarioRepo.save(inventario);
		String alerta = Alert.sweetAlertSuccess("Inventario Nro. "+ registrado.getNumero() + " registrado correctamente");
		flash.addFlashAttribute("alerta", alerta);
		return "redirect:listadoValdivia";
	}
	
	@GetMapping("/editar/{id}")
	public String editarInventario(@PathVariable int id, Model model) {
		model.addAttribute("lstProducto", _producoRepo.findAll());
		Inventario inventario = _inventarioRepo.findById(id).orElseThrow();
		model.addAttribute("inventario", inventario);
		return "actualizarValdivia";
	}
	
	@PostMapping("/actualizar")
	public String actualizarInventario(@ModelAttribute Inventario inventario,Model model,RedirectAttributes flash) {
		model.addAttribute("lstProducto", _producoRepo.findAll());
		Inventario registrado = _inventarioRepo.save(inventario);
		String alerta = Alert.sweetAlertSuccess("Inventario Nro. "+ registrado.getNumero() + " actualizado correctamente");
		flash.addFlashAttribute("alerta", alerta);
		return "redirect:listadoValdivia";
	}
}
