package com.t2Valdivia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2Valdivia.dto.ResultadoResponse;
import com.t2Valdivia.models.Inventario;
import com.t2Valdivia.repositories.IInventarioRepository;

@Service
public class InventarioServices {
	@Autowired
	private IInventarioRepository _inventarioRepo;
	
	public List<Inventario> getAll(){
		return _inventarioRepo.findAllByOrderByNumeroDesc();
	}
	
	public ResultadoResponse createInventario(Inventario i) {
		try {
			Inventario registrado = _inventarioRepo.save(i);
			String mensaje = "Inventario nro. " + registrado.getNumero() + " registrado correctamente";
			return new ResultadoResponse(true, mensaje);
		}
		catch (Exception e) {
			return new ResultadoResponse(false,"Error al crear " + e.getMessage());
		}
	}
	
	public Inventario getOne(int id) {
		return _inventarioRepo.findById(id).orElseThrow();
	}
	
	public ResultadoResponse actualizarInventario(Inventario i) {
		try {
			Inventario registrado = _inventarioRepo.save(i);
			String mensaje = "Inventario nro. " + registrado.getNumero() + " actualizado correctamente";
			return new ResultadoResponse(true, mensaje);
		}
		catch (Exception e) {
			return new ResultadoResponse(false,"Error al actualizar " + e.getMessage());
		}
	}
	
}
