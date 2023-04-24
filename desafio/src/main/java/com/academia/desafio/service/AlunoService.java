package com.academia.desafio.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.desafio.dto.AlunoAtualizarDTO;
import com.academia.desafio.dto.AlunoDTO;
import com.academia.desafio.impl.AlunoImplements;
import com.academia.desafio.model.Aluno;
import com.academia.desafio.model.AvaliacaoFisica;
import com.academia.desafio.repository.AlunoRepository;

@Service
public class AlunoService implements AlunoImplements {

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public Aluno criar(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		aluno.setNome(alunoDTO.getNome());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno buscarPorId(Long id) {
		return alunoRepository.findById(id).get();
	}

	@Override
	public Aluno atualizar(Long id, AlunoAtualizarDTO alunoAtualizarDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(Long id) {
		alunoRepository.deleteById(id);

	}

	@Override
	public List<Aluno> listarTodosAlunos() {
		return alunoRepository.findAll();
	}

	public List<AvaliacaoFisica> buscarTodasAvaliacoesFisicas(Long id) {
		return alunoRepository.findById(id).get().getAvaliacoesFisica();
	}

	@Override
	public List<Aluno> findByDataNascimento(String dataNascimento) {
		// TODO Auto-generated method stub
		if (dataNascimento == null) {
			return alunoRepository.findAll();
		} else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate data = LocalDate.parse(dataNascimento, formatter);
			return alunoRepository.findByDataNascimento(data);
		}
	}

	@Override
	public List<Aluno> findByBairro(String bairro) {
		return alunoRepository.findByBairro(bairro);
	}

}
