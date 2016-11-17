package br.com.fsp.wine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fsp.wine.model.TipoVinho;
import br.com.fsp.wine.model.Vinho;
import br.com.fsp.wine.service.VinhoService;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private VinhoService vinhoService;
	

	@RequestMapping
	public String pesquisa(Model model) {
		model.addAttribute("vinhos", vinhoService.buscarTodos());
		return "/vinho/Listagem";
	}
	
	@RequestMapping("/novo")
	public String novo(Vinho vinho, Model model) {
		model.addAttribute("vinho", vinho);
		model.addAttribute("tipos", TipoVinho.values());
		return "/vinho/Cadastro";
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String salvar(Vinho vinho, Model model) {
		vinhoService.salvar(vinho);
		return novo(new Vinho(), model);
	}
	
}
