package com.t2Valdivia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2Valdivia.models.Inventario;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer>{
	List<Inventario> findAllByOrderByNumeroDesc();
}
