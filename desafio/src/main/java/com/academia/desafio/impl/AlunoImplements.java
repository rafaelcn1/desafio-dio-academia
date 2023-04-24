package com.academia.desafio.impl;

import java.util.List;

import com.academia.desafio.dto.AlunoAtualizarDTO;
import com.academia.desafio.dto.AlunoDTO;
import com.academia.desafio.model.Aluno;

public interface AlunoImplements {
	
	List<Aluno> listarTodosAlunos();

	Aluno criar(AlunoDTO alunoDTO);
	
	Aluno buscarPorId (Long id);
	
	Aluno atualizar (Long id, AlunoAtualizarDTO alunoAtualizarDTO);
	
	void apagar(Long id);
	
	List<Aluno> findByDataNascimento(String dataNascimento);

	List<Aluno> findByBairro(String bairro);
	
	
	
}
