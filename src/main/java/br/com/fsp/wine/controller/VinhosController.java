package br.com.fsp.wine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@RequestMapping("/novo")
	public String novo() {
		return "/vinho/Cadastro";
	}
	
	@RequestMapping
	public String pesquisa() {
		return "/vinho/Listagem";
	}
	
}
