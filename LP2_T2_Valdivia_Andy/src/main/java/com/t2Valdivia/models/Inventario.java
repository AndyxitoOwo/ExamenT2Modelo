package com.t2Valdivia.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_inventario")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "fecha_vencimiento")
	/*Agregado para que pueda recibir la fecha*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaVencimiento;
	
	@JoinColumn(name = "id_producto")
	@ManyToOne(fetch = FetchType.LAZY)
	private Producto producto;
	
	@Column(name = "costo_ingreso")
	private double costoIngreso;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "lote")
	private String lote;
	
	@Column(name = "cod_estado")
	private String codEstado;
}
