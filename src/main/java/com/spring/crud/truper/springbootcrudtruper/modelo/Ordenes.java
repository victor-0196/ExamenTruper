package com.spring.crud.truper.springbootcrudtruper.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Ordenes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 734909809930403613L;
	@Id
	@GeneratedValue
	private Integer orden_id; 
	private Integer sucursal_id; 
	private LocalDate fecha; 
	private Double total;
	
	@OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Productos> productos;
	
	public void addProducto(Productos producto) {
        if (producto != null) {
            if (productos == null) {
            	productos = new ArrayList<>();
            }
            productos.add(producto);
            producto.setOrden(this); // Important: Keep both sides of the relationship in sync
        }
    }

}
