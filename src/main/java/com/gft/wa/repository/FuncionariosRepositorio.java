package com.gft.wa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gft.wa.model.Funcionario;

public interface FuncionariosRepositorio extends JpaRepository<Funcionario, Long>{
	
	List<Funcionario> findByVagaIsNull();
	List<Funcionario> findByVagaIsNotNull();
	
}
