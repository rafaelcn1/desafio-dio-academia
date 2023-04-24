package com.academia.desafio.impl;

import java.util.List;

import com.academia.desafio.dto.AvaliacaoFisicaDTO;
import com.academia.desafio.model.AvaliacaoFisica;

public interface AvaliacaoFisicaImplements {
	
	List<AvaliacaoFisica> listarTodasAvaliacoesFisica();

	AvaliacaoFisica criar(AvaliacaoFisicaDTO avaliacaoFisicaDTO);
	
	AvaliacaoFisica buscarPorId (Long id);
	
	AvaliacaoFisica atualizar (Long id, AvaliacaoFisicaDTO avaliacaoFisicaDTO);
	
	void apagar(Long id);
	
	List<AvaliacaoFisica> listarTodoPorIdDaAvaliacaoFisica(Long id);

}
