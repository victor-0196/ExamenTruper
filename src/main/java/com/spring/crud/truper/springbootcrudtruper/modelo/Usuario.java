package com.spring.crud.truper.springbootcrudtruper.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Usuario implements UserDetails, Serializable{
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = -1667565820006015663L;
		@Id
	 	@GeneratedValue
	    private Integer id;
	 	private String nombreCompleto;
	    private String email;
	    private String password;
	    private LocalDate fechaCreacion; 
	    private LocalDate fechaActualizacion;
	    
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return List.of();
	    }
		@Override
		public String getUsername() {
			  return email;
		} 
}
