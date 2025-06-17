package com.t2Valdivia.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "tbl_categoria")
public class Categoria {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="frecuencia_compra")
	private String FrecuenciaCompra;
}
