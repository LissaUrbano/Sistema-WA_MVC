package com.gft.wa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.wa.model.Tecnologia;
import com.gft.wa.repository.TecnologiaRepositorio;

@Controller
@RequestMapping("/wa/tecnologia/cadastrar")
public class TecnologiaController {

	private static final String CADASTRO_TECNOLOGIA_VIEW = "CadastroTecnologia";
	
	@Autowired
	private TecnologiaRepositorio tecnologiaRepositorio;
	
	@RequestMapping
	public ModelAndView novaGft() {
		ModelAndView mv = new ModelAndView(CADASTRO_TECNOLOGIA_VIEW);
		mv.addObject(new Tecnologia());
		return mv; 
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvarTecnologia(@Validated Tecnologia tecnologia, Errors erros, RedirectAttributes attributes) {
		if (erros.hasErrors()) {
			return CADASTRO_TECNOLOGIA_VIEW;
		} 
		tecnologiaRepositorio.save(tecnologia);
		attributes.addFlashAttribute("mensagem", "Tecnologia cadastrada com sucesso!");
		return CADASTRO_TECNOLOGIA_VIEW; 
	}
	
}
