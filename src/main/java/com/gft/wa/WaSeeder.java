package com.gft.wa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gft.wa.repository.FuncionariosRepositorio;

@Component
public class WaSeeder implements ApplicationRunner {

	@Autowired
	FuncionariosRepositorio funcionarioRepositorio;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		 * adicionarFuncionarios(){
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * adicionarVagas(){
		 * 
		 * 
		 * }
		 */

		
		
		
	}

}
