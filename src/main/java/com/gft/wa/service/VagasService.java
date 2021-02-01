package com.gft.wa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.wa.model.Vaga;
import com.gft.wa.repository.VagasRepositorio;

@Service
public class VagasService {

	@Autowired
	private VagasRepositorio vagasRepositorio;
	
	public List<Vaga> buscarVagasDisponiveis() {
		List<Vaga> todasVagasDisponiveis = vagasRepositorio.findAllByQtdVagaGreaterThan(0);
		return todasVagasDisponiveis;
	}

	public void salvar(Vaga vaga) {
		vagasRepositorio.save(vaga);
	}

	public Object buscarVaga(Long vagaID) {
		return vagasRepositorio.getOne(vagaID);
	}

	public void deletar(Long vagaID) {
		vagasRepositorio.deleteById(vagaID);
	}

}
