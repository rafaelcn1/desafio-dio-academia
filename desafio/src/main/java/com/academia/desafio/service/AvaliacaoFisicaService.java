package com.academia.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.desafio.dto.AvaliacaoFisicaDTO;
import com.academia.desafio.impl.AvaliacaoFisicaImplements;
import com.academia.desafio.model.Aluno;
import com.academia.desafio.model.AvaliacaoFisica;
import com.academia.desafio.repository.AlunoRepository;
import com.academia.desafio.repository.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService implements AvaliacaoFisicaImplements {

	@Autowired
	AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Override
	public List<AvaliacaoFisica> listarTodasAvaliacoesFisica() {
		return avaliacaoFisicaRepository.findAll();
	}

	@Override
	public AvaliacaoFisica criar(AvaliacaoFisicaDTO avaliacaoFisicaDTO) {

		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Optional<Aluno> aluno = alunoRepository.findById(avaliacaoFisicaDTO.getIdAluno());

		avaliacaoFisica.setAluno(aluno.get());
		avaliacaoFisica.setPeso(avaliacaoFisicaDTO.getPeso());
		avaliacaoFisica.setAltura(avaliacaoFisicaDTO.getAltura());

		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica buscarPorId(Long id) {
		return avaliacaoFisicaRepository.findById(id).get();
	}

	@Override
	public AvaliacaoFisica atualizar(Long id, AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(Long id) {
		// TODO Auto-generated method stub
		avaliacaoFisicaRepository.deleteById(id);

	}

	@Override
	public List<AvaliacaoFisica> listarTodoPorIdDaAvaliacaoFisica(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
