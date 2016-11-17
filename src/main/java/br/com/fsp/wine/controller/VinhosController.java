package br.com.fsp.wine.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fsp.wine.model.TipoVinho;
import br.com.fsp.wine.model.Vinho;
import br.com.fsp.wine.service.VinhoService;

import static br.com.fsp.wine.util.ConstantesURL.URL_404;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	private final String VINHO_SALVO_COM_SUCESSO = "Vinho salvo com sucesso.";
	private final String VINHO_DELETADO_COM_SUCESSO = "Vinho deletado com sucesso.";
	
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
	public String salvar(@Valid Vinho vinho, BindingResult resultado, RedirectAttributes atributos, Model model) {
		if (resultado.hasErrors()) {
			return novo(vinho, model);
		}
		vinhoService.salvar(vinho);
		atributos.addFlashAttribute("mensagem", VINHO_SALVO_COM_SUCESSO);
		return "redirect:/vinhos/novo";
	}
	
	@RequestMapping("/editar/{codigo}")
	public String editar(@PathVariable Long codigo, Model model) {
		if (vinhoService.existeVinhoCom(codigo)) {
			return novo(vinhoService.buscarPorCodigo(codigo), model);
		}
		return URL_404;
	}
	
	@RequestMapping("/deletar/{codigo}")
	public String deletar(@PathVariable Long codigo, RedirectAttributes atributos, Model model) {
		if (vinhoService.existeVinhoCom(codigo)) {
			vinhoService.deletarPorCodigo(codigo);
			atributos.addFlashAttribute("mensagem", VINHO_DELETADO_COM_SUCESSO);
			return novo(new Vinho(), model);
		}
		return URL_404;
	}
	
}
