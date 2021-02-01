package com.gft.wa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.wa.model.HistoricoAlocacao;
import com.gft.wa.model.Vaga;
import com.gft.wa.repository.FuncionariosRepositorio;
import com.gft.wa.repository.HistoricoAlocacaoRepositorio;
import com.gft.wa.repository.VagasRepositorio;
import com.gft.wa.viewmodel.AlocacaoViewModel;


@Service
public class AlocacaoService {

	@Autowired
	private VagasRepositorio vagasRepositorio;
	
	@Autowired
	private FuncionariosRepositorio funcionariosRepositorio;
	
	@Autowired
	private HistoricoAlocacaoRepositorio historicoAlocacaoRepositorio;
	
	public void alocar(AlocacaoViewModel alocacaoViewModel) throws Exception{
		
		Long idFuncionario = alocacaoViewModel.getFuncionarioAlocacaoId();
		Long idVaga = alocacaoViewModel.getVagaAlocacaoId();
		
		var resultado = funcionariosRepositorio.findById(idFuncionario);
		Vaga vaga = vagasRepositorio.getOne(idVaga);
		
		if (resultado.isPresent())
		{
			var funcionario = resultado.get();
			Date dataAlocacao = new Date(); 
			
			funcionario.setVaga(vaga);
			funcionario.setTermino_wa(dataAlocacao);
			funcionariosRepositorio.save(funcionario);
		}
		

		if (vaga.getQtdVaga() == 0) {
			throw new Exception("Não é possível alocar nesta Vaga");
		} else {
 			vaga.setQtdVaga(vaga.getQtdVaga() - 1);
 			vagasRepositorio.save(vaga);
		}
		
		var funcionario = resultado.get();
		
		HistoricoAlocacao alocacao= new HistoricoAlocacao();
		alocacao.setFuncionarioAlocacao(funcionario);
		alocacao.setVagaAlocacao(vaga);
		historicoAlocacaoRepositorio.save(alocacao);
		
	}
	
	
}