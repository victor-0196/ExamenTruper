package com.spring.crud.truper.springbootcrudtruper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.crud.truper.springbootcrudtruper.modelo.Sucursales;
import com.spring.crud.truper.springbootcrudtruper.service.repository.SucursalRepository;
import com.spring.crud.truper.springbootcrudtruper.service.utilerias.CargaInicial;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class SpringbootcrudtruperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcrudtruperApplication.class, args);
	}
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	
	@Bean
	CommandLineRunner carga () {
		return args -> {
			List<Sucursales> sucursales = sucursalRepository.findAll(); 
			if (sucursales.isEmpty()) {
				log.info ("Insertando Sucursales:"); 
				sucursalRepository.saveAll(CargaInicial.sucursalesList.get());
			}else {
				log.info("Sucursales Size: {}", sucursales.size());
			}
		};
	}
	
}
