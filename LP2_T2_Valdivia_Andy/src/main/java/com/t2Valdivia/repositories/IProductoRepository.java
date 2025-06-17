package com.t2Valdivia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2Valdivia.models.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}
