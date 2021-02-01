package com.gft.wa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wa")
public class HomeController {

	@RequestMapping
	public String telainicial() {
		return "Home";
	}
	
}
