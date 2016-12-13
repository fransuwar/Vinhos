package br.com.fsp.wine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sun.jna.Function.PostCallRead;

import br.com.fsp.wine.controller.VinhosController;
import br.com.fsp.wine.model.TipoVinho;
import br.com.fsp.wine.model.Vinho;
import br.com.fsp.wine.service.VinhoService;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
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
	
	private List<Vinho> vinhosCadastrados;
	private List<Vinho> listagemVazia;
	
	private final String URL_POST_VINHOS = "/vinhos";
	private final String TELA_LISTAR_VINHOS = "/vinho/Listagem";
	private final String TELA_CADASTRAR_VINHOS = "/vinho/Cadastro";
	private final String URL_CADASTRAR_VINHOS = "/vinhos/novo";
	private final String VINHO_SALVO_COM_SUCESSO = "Vinho salvo com sucesso.";
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(vinhosController).build();
		vinhosCadastrados = new ArrayList<Vinho>();
		listagemVazia = new ArrayList<Vinho>();
	}
	
	@Dado("^que sou um gerente cadastrado no sistema$")
	public void souGerente(){
		//Adiconar validação futura. No momento não há necessidade.
	}
	
	@E("^gostaria de cadastrar vinhos no sistema$")
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
		Mockito.verify(vinhoService).buscarPorCodigo(1L);
	}
	
	@E("^uma mensagem de sucesso deve ser exibida$")
	public void mensagemCadastroComSucesso() throws Throwable{
		resultActions
		.andExpect(MockMvcResultMatchers.view().name(URL_CADASTRAR_VINHOS))
		.andExpect(MockMvcResultMatchers.model().attribute("mensagem", VINHO_SALVO_COM_SUCESSO));
	}
	
	@Quando("^informar tipo (.*), safra (.*), volume (.*) e valor (.*)$")
	public void preencherFormularioSemInformarNomeVinho(String tipo, String safra, String volume, String valor) throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL_POST_VINHOS)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("tipo", tipo)
				.param("safra", safra)
				.param("volume", volume)
				.param("valor", valor));
	}
	
	@Então("^o vinho não deve ser cadastrado no sistema$")
	public void vinhoNaoEstaCadastrado() throws Throwable {
		//Precisa ser refatorado.
		Mockito.verify(vinhoService).buscarPorCodigo(1L);
	}
	
	@E("^uma mensagem de erro deve ser exibida$")
	public void mensagemCadastroFalhou() throws Throwable{
		//Precisa ser refatorado.
		resultActions
		.andExpect(MockMvcResultMatchers.view().name(URL_CADASTRAR_VINHOS))
		.andExpect(MockMvcResultMatchers.model().attributeHasErrors("vinho"));
	}
	
	@Quando("^informar nome (.*), safra (.*), volume (.*) e valor (.*)$")
	public void preencherFormularioSemInformarTipoVinho(String nome, String safra, String volume, String valor) throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL_POST_VINHOS)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("nome", nome)
				.param("safra", safra)
				.param("volume", volume)
				.param("valor", valor));
	}
	
	@Quando("^informar nome (.*), tipo (.*), volume (.*) e valor (.*)$")
	public void preencherFormularioSemInformarSafraVinho(String nome, String tipo, String volume, String valor) throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL_POST_VINHOS)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("nome", nome)
				.param("tipo", tipo)
				.param("volume", volume)
				.param("valor", valor));
	}
	
	@Quando("^informar nome (.*), tipo (.*), safra (.*) e valor (.*)$")
	public void preencherFormularioSemInformarVolumeVinho(String nome, String tipo, String safra, String valor) throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL_POST_VINHOS)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("nome", nome)
				.param("tipo", tipo)
				.param("safra", safra)
				.param("valor", valor));
	}
	
	@Quando("^informar nome (.*), tipo (.*), safra (.*) e volume (.*)$")
	public void preencherFormularioSemInformarValorVinho(String nome, String tipo, String safra, String volume) throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL_POST_VINHOS)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("nome", nome)
				.param("tipo", tipo)
				.param("safra", safra)
				.param("volume", volume));
	}
	
	@Quando("^não informar nome, tipo, safra, volume e valor$")
	public void deixarFormularioVazio() throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL_POST_VINHOS)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED));
	}
}
