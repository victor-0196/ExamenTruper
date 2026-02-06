package com.spring.crud.truper.springbootcrudtruper.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductoDto {
	
	private String codigo; 
	private String descripcion; 
	private Double precio;
	
}
