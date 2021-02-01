package com.gft.wa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.wa.model.Funcionario;
import com.gft.wa.repository.FuncionariosRepositorio;

@Service
public class FuncionariosService {

	@Autowired
	private FuncionariosRepositorio funcionariosRepositorio;
	
	public List<Funcionario> buscarFuncionariosWA() {
		List<Funcionario> todosFuncionariosWA = funcionariosRepositorio.findByVagaIsNull() ;
		return todosFuncionariosWA;
	}
	
	public List<Funcionario> buscarFuncionariosAlocados() {
		List<Funcionario> todosFuncionariosAlocados = funcionariosRepositorio.findByVagaIsNotNull() ;
		return todosFuncionariosAlocados;
	}

	public void salvar(Funcionario funcionarioID) {
		funcionariosRepositorio.save(funcionarioID);
	}

	public Object buscarFuncionario(Long funcionarioID) {
		return funcionariosRepositorio.getOne(funcionarioID);
	}

	public void deletar(Long funcionarioID) {
		funcionariosRepositorio.deleteById(funcionarioID);
	}
	
}
