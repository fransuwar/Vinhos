package br.com.fsp.wine;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.fsp.wine.controller.VinhosController;
import br.com.fsp.wine.service.VinhoService;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;


/**
 * 
 * @author Fransuwar
 * 
 * Esta classe testa os passos para a realização do cadastro de vinhos.
 * Os testes aqui contidos garantem o correto funcionamento do cadastro de vinhos de acordo com as regras estabelecidas.
 *
 */
public class CadastrarVinhosSteps {

	@InjectMocks
	private VinhosController vinhosController;
	
	@Mock
	private VinhoService vinhoService;
	
	private MockMvc mockMvc;
	
	private ResultActions resultActions;
	
	private final String URL_POST_VINHOS = "/vinhos";
	private final String TELA_CADASTRAR_VINHOS = "/vinho/Cadastro";
	private final String URL_CADASTRAR_VINHOS = "/vinhos/novo";
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(vinhosController).build();
	}
	
	@Dado("^que sou um gerente cadastrado no sistema$")
	public void souGerente(){
		//Adiconar validação futura. No momento não há necessidade.
	}
	
	@E("^desejo cadastrar vinhos no sistema$")
	public void desejoCadastraVinhos() throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.get(URL_CADASTRAR_VINHOS));
		resultActions.andExpect(MockMvcResultMatchers.view().name(TELA_CADASTRAR_VINHOS));
	}
	
	@Quando("^informar nome (.*), tipo (.*), safra (.*), volume (.*) e valor (.*)$")
	public void preencherFormularioCorretamente(String nome, String tipo, String safra, String volume, String valor) throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL_POST_VINHOS)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("nome", nome)
				.param("tipo", tipo)
				.param("safra", safra)
				.param("volume", volume)
				.param("valor", valor));
	}
	
	@Então("^o vinho deve ser cadastrado no sistema$")
	public void vinhoEstaCadastrado() throws Throwable {
		//Verificação furuta.
	}
	
	@E("^uma mensagem de sucesso deve ser exibida$")
	public void mensagemCadastroComSucesso() throws Throwable{
		//Verificação futura.
	}
}
