package br.com.fsp.wine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fsp.wine.model.Vinho;
import br.com.fsp.wine.repository.Vinhos;

@Service
public class VinhoService {

	@Autowired
	private Vinhos vinhos;
	
	public void salvar(Vinho vinho){
		vinhos.save(vinho);
	}
}
