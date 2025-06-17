package com.t2Valdivia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2Valdivia.models.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

}
