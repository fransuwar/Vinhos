package br.com.fsp.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fsp.wine.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long>{

}
