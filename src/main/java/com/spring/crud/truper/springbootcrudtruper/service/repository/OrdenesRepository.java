package com.spring.crud.truper.springbootcrudtruper.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.crud.truper.springbootcrudtruper.modelo.Ordenes;

public interface OrdenesRepository extends JpaRepository<Ordenes, Integer>{
	
	@Query (value ="Select ord  From Ordenes ord WHERE ord.orden_id = :idOrden")
	Ordenes  obtenerOrden(@Param ("idOrden") Integer idOrden);

}
