package com.spring.crud.truper.springbootcrudtruper.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrdenesDto {
	private Integer ordenId; 
	private String sucursal; 
	private String fecha; 
	private List<ProductoDto> productos; 
	
	
}
