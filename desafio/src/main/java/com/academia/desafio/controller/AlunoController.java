package com.academia.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academia.desafio.dto.AlunoDTO;
import com.academia.desafio.model.Aluno;
import com.academia.desafio.model.AvaliacaoFisica;
import com.academia.desafio.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public List<Aluno> listarTodosOsAlunos() {
		return alunoService.listarTodosAlunos();
	}

	@PostMapping
	public Aluno criarAluno(@Valid @RequestBody AlunoDTO alunoDTO) {
		return alunoService.criar(alunoDTO);
	}

	@GetMapping("/{id}")
	public Aluno buscarAlunoPorId(@PathVariable Long id) {
		return alunoService.buscarPorId(id);
	}

	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> listarTodasAvaliacoesPorAluno(@PathVariable Long id) {
		return alunoService.buscarTodasAvaliacoesFisicas(id);
	}

	@DeleteMapping("/{id}")
	public void apagarAluno(@PathVariable Long id) {
		alunoService.apagar(id);
	}

	@GetMapping("/aniversarios")
	public List<Aluno> listarAlunosPorDataNascimento(@RequestParam(value = "dataNascimento", required = false) String dataNascimento) {
		return alunoService.findByDataNascimento(dataNascimento);
	}
	
	@GetMapping("/bairro")
	public List<Aluno> listarAlunosPorBairro(@RequestParam(value = "bairro", required = false) String bairro) {
		return alunoService.findByBairro(bairro);
	}
	
}
