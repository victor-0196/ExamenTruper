package com.spring.crud.truper.springbootcrudtruper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.truper.springbootcrudtruper.anotaciones.LogObjectAfter;
import com.spring.crud.truper.springbootcrudtruper.anotaciones.LogObjectBefore;
import com.spring.crud.truper.springbootcrudtruper.anotaciones.LogTiempoEjecucion;
import com.spring.crud.truper.springbootcrudtruper.dto.OrdenesDto;
import com.spring.crud.truper.springbootcrudtruper.dto.ProductoDto;
import com.spring.crud.truper.springbootcrudtruper.service.OrdenesService;

@RestController
@RequestMapping("/ordenes")
public class OrdenesController {
	
	@Autowired
	private OrdenesService  ordenesService;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World"; 
	}
	
	@LogObjectBefore
	@LogObjectAfter
	@LogTiempoEjecucion
	@PostMapping
	public ResponseEntity<OrdenesDto> guardarOrden(@RequestBody OrdenesDto ordenDto){
		OrdenesDto response = ordenesService.guardarOrden(ordenDto);
		return ResponseEntity.ok().body(response);
	}
	
	
	@LogObjectBefore
	@LogObjectAfter
	@LogTiempoEjecucion
	@GetMapping("/{ordenId}")
	public ResponseEntity<OrdenesDto> consultarOrden(@PathVariable Integer ordenId){
		return ResponseEntity.ok().body(ordenesService.recuperarOrden(ordenId));
	}
	
	@LogObjectBefore
	@LogObjectAfter
	@LogTiempoEjecucion
	@PutMapping
	public ResponseEntity<ProductoDto> actualizarPrecio (@RequestBody ProductoDto productoDto){
		return ResponseEntity.ok().body(ordenesService.actualizarPrecioProducto(productoDto));
	}
	
	
	
	
	
}
