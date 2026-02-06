package com.spring.crud.truper.springbootcrudtruper.service.utilerias;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.spring.crud.truper.springbootcrudtruper.modelo.Sucursales;

public class CargaInicial {
	
	
	public static Supplier<List<Sucursales>> sucursalesList = () ->
			Arrays.asList(
							Sucursales.builder().nombre("CDMX").build(), 
							Sucursales.builder().nombre("Guanajuato").build(),
							Sucursales.builder().nombre("Guadalajara").build() 
						);
			
			

}
