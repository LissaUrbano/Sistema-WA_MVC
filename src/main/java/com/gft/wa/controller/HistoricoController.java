package com.gft.wa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gft.wa.service.HistoricoAlocacaoService;

@Controller
@RequestMapping("/wa/historico")
public class HistoricoController {

	@Autowired
	private HistoricoAlocacaoService historicoAlocacaoService;
	
	@RequestMapping
	public ModelAndView buscarHistoricoWa() {
		ModelAndView mv = new ModelAndView("HistoricoWA");
		mv.addObject("todasAlocacoes", historicoAlocacaoService.buscarFuncionariosAlocados());
		return mv;
	}
	
}
