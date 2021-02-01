package com.gft.wa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.wa.model.HistoricoAlocacao;
import com.gft.wa.repository.HistoricoAlocacaoRepositorio;

@Service
public class HistoricoAlocacaoService {
	
	@Autowired
	private HistoricoAlocacaoRepositorio historicoAlocacaoRepositorio;
	
	public List<HistoricoAlocacao> buscarFuncionariosAlocados() {
		List<HistoricoAlocacao> todosFuncionarioAlocados = historicoAlocacaoRepositorio.findAll();
		return todosFuncionarioAlocados;
	}
	
}
