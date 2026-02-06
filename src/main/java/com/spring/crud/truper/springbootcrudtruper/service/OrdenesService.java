package com.spring.crud.truper.springbootcrudtruper.service;

import com.spring.crud.truper.springbootcrudtruper.dto.OrdenesDto;

public interface OrdenesService {
	
	OrdenesDto guardarOrden (OrdenesDto ordenDto);
	
	 OrdenesDto recuperarOrden(String idOrden); 
	
	
	

}
