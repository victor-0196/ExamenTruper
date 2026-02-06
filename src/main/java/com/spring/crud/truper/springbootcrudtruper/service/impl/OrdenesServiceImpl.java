package com.spring.crud.truper.springbootcrudtruper.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		orden.setFecha(convertirFecha (ordenDto.getFecha()));
		orden.setTotal(calcularTotal(ordenDto.getProductos()));
		
		
		orden= ordenesRepository.save(orden);
		
		
		List<Productos>  productos = obtenerListaProductos(ordenDto.getProductos(), orden.getOrden_id());
	
		productoRepository.saveAll(productos);
		
		
		ordenDto.setOrdenId(orden.getOrden_id());
		return ordenDto;
		
	}
	
	public OrdenesDto recuperarOrden(String idOrden) {
		Ordenes orden =     ordenesRepository.obtenerOrden(Integer.valueOf(idOrden)); 
		OrdenesDto ordenDto= new OrdenesDto ().builder().ordenId(orden.getOrden_id()). sucursal(orden.getSucursal_id().toString()    ).fecha(orden.getFecha().toString()).build()      ; 
		return ordenDto; 
	}
	
	
	private Sucursales obtenerSucursal (String nombreSucursal) {
		return sucursalRepository.obtenerSucursalOrden(nombreSucursal);
	}
	
	private Date convertirFecha (String fecha) {
		DateFormat format = new SimpleDateFormat("DD-MM-YYYY"); 
		try {
			Date fechaSalida = format.parse(fecha);
			return fechaSalida;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	private Double calcularTotal(List<ProductoDto> productos) {
		return productos.stream().mapToDouble(ProductoDto::getPrecio).sum();
	}
	
	
	private List<Productos> obtenerListaProductos(List<ProductoDto> productosDto, Integer ordenId){
		List<Productos> productos = new ArrayList<>(); 
		for (ProductoDto prod: productosDto) {
			productos.add(new Productos().builder().ordenId(ordenId).descripcion(prod.getDescripcion()).precio(prod.getPrecio()).build());
		}
		return productos;
	}
	
	

}
