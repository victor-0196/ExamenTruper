package com.spring.crud.truper.springbootcrudtruper.modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Ordenes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 734909809930403613L;
	@Id
	@GeneratedValue
	private Integer orden_id; 
	private Integer sucursal_id; 
	private Date fecha; 
	private Double total; 
	
	

}
