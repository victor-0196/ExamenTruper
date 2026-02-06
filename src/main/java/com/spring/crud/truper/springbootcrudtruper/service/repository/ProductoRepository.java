package com.spring.crud.truper.springbootcrudtruper.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.spring.crud.truper.springbootcrudtruper.modelo.Productos;



public interface ProductoRepository extends JpaRepository<Productos, Integer>{
	
	
	@Query (value ="Select prod  From Productos prod WHERE prod.codigo = :codigoProducto")
	Optional<Productos> buscarPorCodigo(@Param ("codigoProducto") String codigoProducto);
		
}
