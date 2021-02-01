package com.gft.wa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.gft.wa.model.Vaga;

public interface VagasRepositorio extends JpaRepository<Vaga, Long>{

	List<Vaga> findAllByQtdVagaGreaterThan(int qtd);
	
}
