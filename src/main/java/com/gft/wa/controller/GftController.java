package com.gft.wa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.wa.model.Gft;
import com.gft.wa.repository.GftRepositorio;

@Controller
@RequestMapping("/wa/gft/cadastrar")
public class GftController {

	
	private static final String CADASTRO_GFT_VIEW = "CadastroGft";
	
	@Autowired
	private GftRepositorio gftRepositorio;
	
	/*--------------------------Request-------------------------*/
	
	@RequestMapping
	public ModelAndView novaGft() {
		ModelAndView mv = new ModelAndView(CADASTRO_GFT_VIEW);
		mv.addObject(new Gft());
		return mv; 
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvarGft(@Validated Gft gft, Errors erros, RedirectAttributes attributes) {
		if (erros.hasErrors()) {
			return CADASTRO_GFT_VIEW;
		} 
		
		gftRepositorio.save(gft);
		attributes.addFlashAttribute("mensagem", "Unidade GFT cadastrada com sucesso!");
		return CADASTRO_GFT_VIEW; /* "redirect:/wa/vagas" alterar quando criar a tabela lista*/
	}
}
