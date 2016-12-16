package br.com.fsp.wine;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.fsp.wine.controller.VinhosController;
import br.com.fsp.wine.model.Vinho;
import br.com.fsp.wine.service.VinhoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WineApplication.class)
@WebAppConfiguration
public class VinhoServiceTests {

	@InjectMocks
	private VinhosController vinhosController;
	
	@Mock
	private VinhoService vinhoService;
	
	private MockMvc mockMvc;
	
	private ResultActions resultActions;
	
	private List<Vinho> vinhosCadastrados;
	private Long codigo;
	private Vinho vinho;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(vinhosController).build();
		vinhosCadastrados = new ArrayList<Vinho>();
		codigo = new Long(1);
		vinho = new Vinho();
		vinho.setCodigo(codigo);
	}
	
	@Test
	public void quandoBuscarTodosDeveRetornarListaDeVinhos() throws Throwable{
		Mockito.when(vinhoService.buscarTodos()).thenReturn(vinhosCadastrados);
	}
	
	@Test
	public void quandoBuscarPorCodigoDeveRetornarVinho() throws Throwable{
		Mockito.when(vinhoService.buscarPorCodigo(codigo)).thenReturn(vinho);
	}

}
