package br.com.fsp.wine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.fsp.wine.controller.VinhosController;
import br.com.fsp.wine.service.VinhoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WineApplication.class)
@WebAppConfiguration
public class VinhosControllerTests {

	@InjectMocks
	private VinhosController vinhosController;
	
	@Mock
	private VinhoService vinhoService;
	
	private MockMvc mockMvc;
	
	private ResultActions resultActions;
	
	private final String URL_LISTAR_VINHOS = "/vinhos";
	private final String TELA_LISTAR_VINHOS = "/vinho/Listagem";
	private final String TELA_CADASTRAR_VINHOS = "/vinho/Cadastro";
	private final String URL_CADASTRAR_VINHOS = "/vinhos/novo";
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(vinhosController).build();
	}
	
	@Test
	public void selecionarListagemVinhosDeveRetonarPaginaListagemVinhos() throws Exception {
		resultActions = mockMvc.perform(MockMvcRequestBuilders.get(URL_LISTAR_VINHOS));
		resultActions.andExpect(MockMvcResultMatchers.view().name(TELA_LISTAR_VINHOS));
	}
	
	@Test
	public void selecionarCadastrarVinhoDeveRetonarPaginaCadastroDeVinhos() throws Exception {
		resultActions = mockMvc.perform(MockMvcRequestBuilders.get(URL_CADASTRAR_VINHOS));
		resultActions.andExpect(MockMvcResultMatchers.view().name(TELA_CADASTRAR_VINHOS));
	}

}
