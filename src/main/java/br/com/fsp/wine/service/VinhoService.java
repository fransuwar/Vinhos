package br.com.fsp.wine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fsp.wine.model.Vinho;
import br.com.fsp.wine.repository.Vinhos;

@Service
public class VinhoService {

	@Autowired
	private Vinhos vinhos;
	
	public List<Vinho> buscarTodos(){
		return vinhos.findAll();
	}
	
	public void salvar(Vinho vinho){
		vinhos.save(vinho);
	}
}
