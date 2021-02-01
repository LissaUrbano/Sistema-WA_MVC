package com.gft.wa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.wa.model.Tecnologia;
import com.gft.wa.model.Vaga;
import com.gft.wa.repository.TecnologiaRepositorio;
import com.gft.wa.service.VagasService;

@Controller
@RequestMapping("/wa/vagas")
public class VagaController {
	
	@Autowired
	private TecnologiaRepositorio tecnologiaRepositorio;
	
	@ModelAttribute("todasTecnologias")
	public List<Tecnologia> tecnologias(){
		return tecnologiaRepositorio.findAll();
	}
	
	private static final String CADASTRO_VAGA_VIEW = "CadastroVaga";
	
	@Autowired
	private VagasService vagasService;
	
	/*--------------------------Request-------------------------*/
	
	@RequestMapping
	public ModelAndView pesquisarVagas() { 
		ModelAndView mv = new ModelAndView("Vagas");
		mv.addObject("todasVagas", vagasService.buscarVagasDisponiveis());
		return mv; 
	}
	
	@RequestMapping("/cadastrar")
	public ModelAndView novaVaga() {
		ModelAndView mv = new ModelAndView(CADASTRO_VAGA_VIEW);
		mv.addObject(new Vaga());
		return mv; 
	}
	
	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public String salvarVaga(@Validated Vaga vaga, Errors erros, RedirectAttributes attributes) {
		if (erros.hasErrors()) {
			return CADASTRO_VAGA_VIEW;
		} 
		vagasService.salvar(vaga);
		attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
		return "redirect:/wa/vagas";
	}
	
	
	@RequestMapping("cadastrar/{codigo}")
	public ModelAndView	edicaoVaga(@PathVariable("codigo") Long vagaID, RedirectAttributes attributes){ 
		ModelAndView mv = new ModelAndView(CADASTRO_VAGA_VIEW); 
		mv.addObject(vagasService.buscarVaga(vagaID));
		attributes.addFlashAttribute("mensagem", "Vaga atualizada com sucesso!");
		return mv; 
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluirVaga(@PathVariable("codigo") Long vagaID, RedirectAttributes attributes){ 
		vagasService.deletar(vagaID);
		attributes.addFlashAttribute("mensagem", "Vaga excluída com sucesso!");
		return "redirect:/wa/vagas"; 
	}

}
