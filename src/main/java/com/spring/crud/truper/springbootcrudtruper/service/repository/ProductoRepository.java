package com.spring.crud.truper.springbootcrudtruper.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.truper.springbootcrudtruper.modelo.Productos;



public interface ProductoRepository extends JpaRepository<Productos, Integer>{

}
