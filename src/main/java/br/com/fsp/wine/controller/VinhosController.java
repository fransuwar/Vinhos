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

/**
 * Controla as requisições HTTP para a entidade Vinho. Direcionando todas as requisições de cadastro, 
 * exclusão, listagem e edição de vinhos para suas respectivas páginas.
 * 
 * @author Fransuwar
 *
 */

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	private final String VINHO_SALVO_COM_SUCESSO = "Vinho salvo com sucesso.";
	private final String VINHO_DELETADO_COM_SUCESSO = "Vinho deletado com sucesso.";
	
	private final String NOT_FOUND ="/404";
	
	@Autowired
	private VinhoService vinhoService;
	

	/**
	 * Redireciona para a página de listagem de vinhos.
	 * 
	 * @param model será injetado pelo framework Spring para manipulação da página.
	 * @return o identificador da página de listagem de vinhos.
	 */
	@RequestMapping
	public String pesquisa(Model model) {
		model.addAttribute("vinhos", vinhoService.buscarTodos());
		return "/vinho/Listagem";
	}
	
	/**
	 * Prepara os dados da requisição para cadastro de um novo vinho e redireciona para a página de cadastro.
	 * 
	 * @param vinho será injetado pelo framework Spring para ser preenchido da página de cadastro.
	 * @param model será injetado pelo framework Spring para manipulação da página.
	 * @return o identificador da página de cadastro de vinhos.
	 */
	@RequestMapping("/novo")
	public String novo(Vinho vinho, Model model) {
		model.addAttribute("vinho", vinho);
		model.addAttribute("tipos", TipoVinho.values());
		return "/vinho/Cadastro";
	}
	
	/**
	 * Realiza o cadastro de um novo vinho no sistema e retorna para a página de cadastro de vinhos em caso de sucesso.
	 * 
	 * @param vinho que será cadastrado no sistema.
	 * @param resultado mensagem de feedback referente ao cadastro.
	 * @param atributos resultados da validação do formulario.
	 * @param model será injetado pelo framework Spring para manipulação da página.
	 * @return o identificador da página de cadastro de vinhos.
	 */
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String salvar(@Valid Vinho vinho, BindingResult resultado, RedirectAttributes atributos, Model model) {
		if (resultado.hasErrors()) {
			return novo(vinho, model);
		}
		vinhoService.salvar(vinho);
		atributos.addFlashAttribute("mensagem", VINHO_SALVO_COM_SUCESSO);
		return "redirect:/vinhos/novo";
	}
	
	/**
	 * Realiza a edição dos dados de um vinho cadastrado no sistema e retorna para a página de cadastro de vinhos em caso de sucesso, 
	 * página de erro 404 caso contrário.
	 * 
	 * @param codigo do vinho que será editado.
	 * @param model será injetado pelo framework Spring para manipulação da página.
	 * @return o identificador da página de cadastro de vinhos caso o código seja válido, página de erro 404 caso contrário.
	 */
	@RequestMapping("/editar/{codigo}")
	public String editar(@PathVariable Long codigo, Model model) {
		if (vinhoService.existeVinhoCom(codigo)) {
			return novo(vinhoService.buscarPorCodigo(codigo), model);
		}
		return NOT_FOUND;
	}
	
	/**
	 * Realiza a exclusão de um vinho cadastrado no sistema e retorna para a página de listagem de vinhos em caso de sucesso, 
	 * página de erro 404 caso contrário.
	 * 
	 * @param codigo codigo do vinho que será excluído.
	 * @param atributos resultados da validação do formulario.
	 * @param model será injetado pelo framework Spring para manipulação da página.
	 * @return o identificador da página de listagem de vinhos caso o código seja válido, página de erro 404 caso contrário.
	 */
	@RequestMapping("/deletar/{codigo}")
	public String deletar(@PathVariable Long codigo, RedirectAttributes atributos, Model model) {
		if (vinhoService.existeVinhoCom(codigo)) {
			vinhoService.deletarPorCodigo(codigo);
			atributos.addFlashAttribute("mensagem", VINHO_DELETADO_COM_SUCESSO);
			return "redirect:/vinhos";
		}
		return NOT_FOUND;
	}
	
}
