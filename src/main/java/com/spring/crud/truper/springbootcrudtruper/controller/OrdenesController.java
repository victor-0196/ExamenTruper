package com.spring.crud.truper.springbootcrudtruper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.truper.springbootcrudtruper.dto.OrdenesDto;
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
	
	
	@PostMapping
	public ResponseEntity<OrdenesDto> guardarOrden(@RequestBody OrdenesDto ordenDto){
		OrdenesDto response = ordenesService.guardarOrden(ordenDto);
		return ResponseEntity.ok().body(response);
	}
	
	
	
}
