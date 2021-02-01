package com.gft.wa.controller;

import java.util.Arrays;
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

import com.gft.wa.model.CargosFuncionario;
import com.gft.wa.model.Funcionario;
import com.gft.wa.model.Gft;
import com.gft.wa.model.Tecnologia;
import com.gft.wa.repository.GftRepositorio;
import com.gft.wa.repository.TecnologiaRepositorio;
import com.gft.wa.service.FuncionariosService;

@Controller
@RequestMapping("/wa/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private TecnologiaRepositorio tecnologiaRepositorio;
	
	@Autowired
	private GftRepositorio gftRepositorio;
	
	@ModelAttribute("todosCargos") //enum
	public List<CargosFuncionario> cargos(){
		return Arrays.asList(CargosFuncionario.values());
	}
	
	@ModelAttribute("todasTecnologias")
	public List<Tecnologia> tecnologias(){
		return tecnologiaRepositorio.findAll();
	}
	
	@ModelAttribute("todosLocaisTrabalho")
	public List<Gft> locaisTrabalho(){
		return gftRepositorio.findAll();
	}
	
	/*----------------------------------------------------------*/
	
	private static final String CADASTRO_FUNCIONARIO_VIEW= "CadastroFuncionario";
	
	
	@Autowired
	private FuncionariosService funcionariosService;
	
	/*--------------------------Request-------------------------*/
	
	@RequestMapping
	public ModelAndView pesquisarFuncionarios() {
		ModelAndView mv = new ModelAndView("Funcionarios");
		mv.addObject("todosFuncionarios", funcionariosService.buscarFuncionariosWA());
		return mv; 
	}
	
	
	@RequestMapping("/cadastrar")
	public ModelAndView novoFuncionario() {
		ModelAndView mv = new ModelAndView(CADASTRO_FUNCIONARIO_VIEW);
		mv.addObject(new Funcionario());
		return mv;
	}
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String salvarFuncionario(@Validated Funcionario funcionario, Errors erros, RedirectAttributes attributes) {
		if (erros.hasErrors()) {
			return CADASTRO_FUNCIONARIO_VIEW;
		} 
		
		funcionariosService.salvar(funcionario);
		attributes.addFlashAttribute("mensagem", "Cadastro de funcionário efetuado com sucesso!");
		return "redirect:/wa/funcionarios";
	}
	
	 
	@RequestMapping("/cadastrar/{codigo}")
	public ModelAndView	edicaoFuncionario(@PathVariable("codigo") Long funcionarioID){ 
		ModelAndView mv = new ModelAndView(CADASTRO_FUNCIONARIO_VIEW); 
		mv.addObject(funcionariosService.buscarFuncionario(funcionarioID));
		return mv; 
		
	}
	
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public String excluirFuncionario(@PathVariable("codigo") Long funcionarioID, RedirectAttributes attributes){ 
		funcionariosService.deletar(funcionarioID); 
		attributes.addFlashAttribute("mensagem", "Cadastro de funcionário excluído com sucesso!");
		return "redirect:/wa/funcionarios"; 
	}

}
