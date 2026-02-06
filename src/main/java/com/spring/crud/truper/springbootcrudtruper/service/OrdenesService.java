package com.spring.crud.truper.springbootcrudtruper.service;

import com.spring.crud.truper.springbootcrudtruper.dto.OrdenesDto;
import com.spring.crud.truper.springbootcrudtruper.dto.ProductoDto;

public interface OrdenesService {
	
	 OrdenesDto guardarOrden (OrdenesDto ordenDto);
	
	 OrdenesDto recuperarOrden(Integer idOrden); 
	 
	 ProductoDto actualizarPrecioProducto(ProductoDto productoDto);
}
