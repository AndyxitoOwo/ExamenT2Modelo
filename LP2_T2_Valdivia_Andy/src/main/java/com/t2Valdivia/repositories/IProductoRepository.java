package com.t2Valdivia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2Valdivia.models.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> findAllByOrderByNombre();

}
