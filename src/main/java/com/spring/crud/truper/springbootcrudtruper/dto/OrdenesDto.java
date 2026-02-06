package com.spring.crud.truper.springbootcrudtruper.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
	private LocalDate fecha; 
	private List<ProductoDto> productos; 
	private Double total; 
	
	
}
