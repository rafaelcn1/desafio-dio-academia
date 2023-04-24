package com.academia.desafio.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.academia.desafio.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	/*
	 * Metodo para listar alunos por data de nascimento
	 */
	List<Aluno> findByDataNascimento(LocalDate dataNascimento);

	/*
	 * Metodo para listar por bairros, pode ser assim ou até mesmo como a linguagem
	 * SQL
	 */
	@Query("FROM Aluno a WHERE a.bairro = :bairro")
	List<Aluno> findByBairro(String bairro);

}
