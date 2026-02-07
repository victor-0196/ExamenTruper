package com.spring.crud.truper.springbootcrudtruper.dto.auth;

 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginUsuarioDto {
	
	private String email;
	private String password;
	

}
