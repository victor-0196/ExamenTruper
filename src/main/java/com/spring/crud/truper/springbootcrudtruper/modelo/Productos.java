package com.spring.crud.truper.springbootcrudtruper.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Productos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4076732571700558228L;
	
	@Id
	@GeneratedValue
	private Integer productoId; 
	@ManyToOne
	@JoinColumn(name = "orden_id", nullable = false)
	private Ordenes orden;
	private String codigo; 
	private String descripcion; 
	private Double precio; 
	
	
	
}
