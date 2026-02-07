package com.spring.crud.truper.springbootcrudtruper.service.auth;

 
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.crud.truper.springbootcrudtruper.dto.auth.LoginUsuarioDto;
import com.spring.crud.truper.springbootcrudtruper.dto.auth.RegistrarUsuarioDto;
import com.spring.crud.truper.springbootcrudtruper.modelo.Usuario;
import com.spring.crud.truper.springbootcrudtruper.service.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {

	private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario signup(RegistrarUsuarioDto input) {
    	Usuario user = new Usuario().builder()
            .nombreCompleto(input.getNombreCompleto())
            .email(input.getEmail())
            .password(passwordEncoder.encode(input.getPassword())).build();

        return usuarioRepository.save(user);
    }

    public Usuario autenticar(LoginUsuarioDto input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
            )
        );
        return usuarioRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    public List<Usuario> allUsers() {
        List<Usuario> users = new ArrayList<>();
        usuarioRepository.findAll().forEach(users::add);
        return users;
    }
}
