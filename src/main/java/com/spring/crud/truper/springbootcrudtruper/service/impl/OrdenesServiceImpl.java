package com.spring.crud.truper.springbootcrudtruper.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.truper.springbootcrudtruper.dto.OrdenesDto;
import com.spring.crud.truper.springbootcrudtruper.dto.ProductoDto;
import com.spring.crud.truper.springbootcrudtruper.modelo.Ordenes;
import com.spring.crud.truper.springbootcrudtruper.modelo.Productos;
import com.spring.crud.truper.springbootcrudtruper.modelo.Sucursales;
import com.spring.crud.truper.springbootcrudtruper.service.OrdenesService;
import com.spring.crud.truper.springbootcrudtruper.service.repository.OrdenesRepository;
import com.spring.crud.truper.springbootcrudtruper.service.repository.ProductoRepository;
import com.spring.crud.truper.springbootcrudtruper.service.repository.SucursalRepository;


@Service
public class OrdenesServiceImpl implements OrdenesService{
	
	@Autowired
	private OrdenesRepository ordenesRepository;
	
	@Autowired
	private ProductoRepository productoRepository; 
	
	@Autowired
	private SucursalRepository sucursalRepository; 
	
	
	public OrdenesDto guardarOrden (OrdenesDto ordenDto) {
		Ordenes orden = new Ordenes(); 
		
		Sucursales sucursalOrden = obtenerSucursal(ordenDto.getSucursal());
		
		orden.setSucursal_id(sucursalOrden.getSucursalId());
		orden.setFecha(ordenDto.getFecha());
		orden.setTotal(calcularTotal(ordenDto.getProductos()));

		for (ProductoDto prod: ordenDto.getProductos()) {
			orden.addProducto((new Productos().builder().codigo(prod.getCodigo()).descripcion(prod.getDescripcion()).precio(prod.getPrecio()).build()));
		}
		
		
		orden= ordenesRepository.save(orden);
		ordenDto.setTotal(orden.getTotal());
		ordenDto.setOrdenId(orden.getOrden_id());
		return ordenDto;
		
	}
	
	public OrdenesDto recuperarOrden(Integer idOrden) {
		Ordenes orden =  ordenesRepository.getReferenceById( idOrden);  
		
		List<ProductoDto> productosDto = new ArrayList<>();
		for (Productos prod: orden.getProductos()) {
			productosDto.add(ProductoDto.builder().codigo(prod.getCodigo()).descripcion(prod.getDescripcion()).precio(prod.getPrecio()).build()); 
		}
		OrdenesDto ordenDto= new OrdenesDto ().builder().ordenId(orden.getOrden_id()). sucursal(orden.getSucursal_id().toString()).fecha(orden.getFecha()).productos(productosDto).total(orden.getTotal())   .build(); 
		return ordenDto; 
	}
	
	
	public ProductoDto actualizarPrecioProducto(ProductoDto productoDto) {
		Optional<Productos> producto =   productoRepository.buscarPorCodigo(productoDto.getCodigo());
		if(producto.isPresent()) {
			Productos prod = producto.get();
			prod.setPrecio(productoDto.getPrecio());
			productoRepository.save(producto.get());
			return productoDto;
		}
		return new ProductoDto().builder().descripcion("Producto no encontrado").build(); 
	}
	
	
	
	private Sucursales obtenerSucursal (String nombreSucursal) {
		return sucursalRepository.obtenerSucursalOrden(nombreSucursal);
	}
	
	private Double calcularTotal(List<ProductoDto> productos) {
		return productos.stream().mapToDouble(ProductoDto::getPrecio).sum();
	}
	
 
	
	

}
