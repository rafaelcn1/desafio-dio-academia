package com.academia.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.desafio.dto.AvaliacaoFisicaDTO;
import com.academia.desafio.model.AvaliacaoFisica;
import com.academia.desafio.service.AvaliacaoFisicaService;

@RequestMapping("/avaliacoes")
@RestController
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;

	@PostMapping
	public AvaliacaoFisica criar(@RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
		return avaliacaoFisicaService.criar(avaliacaoFisicaDTO);
	}

	@GetMapping
	public List<AvaliacaoFisica> listarTodasAvaliacoesFisicas() {
		return avaliacaoFisicaService.listarTodasAvaliacoesFisica();
	}

	@GetMapping("/{id}")
	public AvaliacaoFisica listaAvaliacaoFisicaPorId(@PathVariable Long id) {
		return avaliacaoFisicaService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void apagarAvaliacaoFisicaPorId(@PathVariable Long id) {
		avaliacaoFisicaService.apagar(id);
	}
}
