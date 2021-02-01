package com.gft.wa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.wa.service.AlocacaoService;
import com.gft.wa.service.FuncionariosService;
import com.gft.wa.service.VagasService;
import com.gft.wa.viewmodel.AlocacaoViewModel;

@Controller
@RequestMapping("/wa/alocacao")
public class AlocacaoController {
	
	@Autowired
	private FuncionariosService funcionariosService;
	
	@Autowired
	private VagasService vagasService;
	
	@Autowired
	private AlocacaoService alocacaoService;
	
	private static final String ALOCACAO_VIEW= "Alocacao";
	
	/*--------------------------Request-------------------------*/
	
	@RequestMapping
	public ModelAndView novaAlocacao(@RequestParam Optional<Long> funcionarioId, Optional<Long> vagaId) {
		ModelAndView mv = new ModelAndView(ALOCACAO_VIEW);
		mv.addObject(new AlocacaoViewModel());
		mv.addObject("todosFuncionarios", funcionariosService.buscarFuncionariosWA());
		mv.addObject("todasVagas", vagasService.buscarVagasDisponiveis());
		mv.addObject("funcionarioSelecionado", funcionarioId);
		mv.addObject("vagaSelecionada", vagaId);
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvarAlocacao(AlocacaoViewModel alocacaoViewModel, RedirectAttributes attributes) throws Exception {
		alocacaoService.alocar(alocacaoViewModel);
		attributes.addFlashAttribute("mensagem", "Alocacao efetuada com sucesso!");
		return "redirect:/wa/historico";
	}

}
