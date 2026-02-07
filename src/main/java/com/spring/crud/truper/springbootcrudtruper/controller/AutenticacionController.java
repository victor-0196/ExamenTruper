package com.spring.crud.truper.springbootcrudtruper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.truper.springbootcrudtruper.dto.auth.LoginResponseDto;
import com.spring.crud.truper.springbootcrudtruper.dto.auth.LoginUsuarioDto;
import com.spring.crud.truper.springbootcrudtruper.dto.auth.RegistrarUsuarioDto;
import com.spring.crud.truper.springbootcrudtruper.modelo.Usuario;
import com.spring.crud.truper.springbootcrudtruper.service.auth.AuthenticationService;
import com.spring.crud.truper.springbootcrudtruper.service.auth.JwtService;

@RequestMapping("/auth")
@RestController
public class AutenticacionController {

	  private final JwtService jwtService;
	  private final AuthenticationService authenticationService;

	  public AutenticacionController(JwtService jwtService, AuthenticationService authenticationService) {
	        this.jwtService = jwtService;
	        this.authenticationService = authenticationService;
	  }
	  
	  
	  @PostMapping("/signup")
	  public ResponseEntity<Usuario> register(@RequestBody RegistrarUsuarioDto registrarUserDto) {
		    Usuario registeredUser = authenticationService.signup(registrarUserDto);
	        return ResponseEntity.ok(registeredUser);
	  }

	  @PostMapping("/login")
	  public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginUsuarioDto loginUsuarioDto) {
	    	Usuario authenticatedUser = authenticationService.autenticar(loginUsuarioDto);
	        String jwtToken = jwtService.generateToken(authenticatedUser);
	        LoginResponseDto loginResponse = new LoginResponseDto().builder().token(jwtToken).expiracion(jwtService.getExpirationTime()).build();
	        return ResponseEntity.ok(loginResponse);
	  }
	
}
