package com.spring.crud.truper.springbootcrudtruper.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.crud.truper.springbootcrudtruper.modelo.Sucursales;


public interface SucursalRepository extends JpaRepository<Sucursales, Integer>{
	
	
	@Query (value ="Select suc  From Sucursales suc WHERE suc.nombre = :nombreSucursal")
	Sucursales obtenerSucursalOrden(@Param ("nombreSucursal") String nombreSucursal);
	

}
