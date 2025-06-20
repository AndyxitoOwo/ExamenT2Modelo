package com.t2Valdivia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2Valdivia.models.Producto;
import com.t2Valdivia.repositories.IProductoRepository;

@Service
public class ProductoServices {
	@Autowired
	private IProductoRepository _productorepo;
	
	public List<Producto> getAll(){
		return _productorepo.findAllByOrderByNombre();
	}
}
