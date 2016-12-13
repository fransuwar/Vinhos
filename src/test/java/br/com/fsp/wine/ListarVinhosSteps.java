package br.com.fsp.wine;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.fsp.wine.controller.VinhosController;
import br.com.fsp.wine.model.Vinho;
import br.com.fsp.wine.service.VinhoService;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

/**
 * 
 * @author Fransuwar
 * 
 * Esta classe testa os passos para listar os vinhos cadastrados no sistema.
 * Os testes aqui contidos garantem o correto funcionamento da listagem de vinhos de acordo com as regras estabelecidas.
 *
 */
public class ListarVinhosSteps {

	@InjectMocks
	private VinhosController vinhosController;
	
	@Mock
	private VinhoService vinhoService;
	
	private MockMvc mockMvc;
	
	private ResultActions resultActions;
	
	private List<Vinho> vinhosCadastrados;
	private List<Vinho> listagemVazia;
	
	private final String URL_LISTAR_VINHOS = "/vinhos";
	private final String TELA_LISTAR_VINHOS = "/vinho/Listagem";
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(vinhosController).build();
		vinhosCadastrados = new ArrayList<Vinho>();
		listagemVazia = new ArrayList<Vinho>();
	}
	
	@Dado("^que sou um funcionário cadastrado no sistema$")
	public void souFuncionario(){
		//Adiconar validação futura. No momento não há necessidade.
	}
	
	@E("^gostaria de consultar os vinhos cadastrados no sistema$")
	public void desejaListaVinhos() throws Throwable{
		//Adiconar no futura. No momento não há necessidade.
	}
	
	@Quando("^seleciono a opção para listar vinhos$")
	public void selecionarOpcaoListarVinhos() throws Throwable{
		resultActions = mockMvc.perform(MockMvcRequestBuilders.get(URL_LISTAR_VINHOS));
		resultActions.andExpect(MockMvcResultMatchers.view().name(TELA_LISTAR_VINHOS));
	}
	
	@E("^existem vinhos cadastrados no sistema$")
	public void existemVinhosCadastrados() throws Throwable{
		Mockito.when(vinhoService.buscarTodos()).thenReturn(vinhosCadastrados);
	}
	
	@E("^não existem vinhos cadastrados no sistema$")
	public void naoExistemVinhosCadastrados() throws Throwable{
		Mockito.when(vinhoService.buscarTodos()).thenReturn(listagemVazia);
	}
	
	@Entao("^os vinhos cadastrados no sistema são listados$")
	public void listarVinhosCadastrados() throws Throwable{
		resultActions.andExpect(MockMvcResultMatchers.model().attribute("vinhos", vinhosCadastrados));
	}
	
	@Entao("^uma mensagem de feedback deve ser exibida$")
	public void exibirFeedbakNaoHaVinhosCadastrados() throws Throwable{
		resultActions.andExpect(MockMvcResultMatchers.model().attribute("vinhos", listagemVazia));
	}
}
