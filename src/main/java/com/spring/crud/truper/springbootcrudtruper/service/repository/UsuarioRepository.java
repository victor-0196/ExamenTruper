package com.spring.crud.truper.springbootcrudtruper.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.truper.springbootcrudtruper.modelo.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}
