package com.academia.desafio.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Para não precisar criar os GETs e SETs
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

	private String nome;

	private String cpf;

	private String bairro;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@NotBlank(message = "Preencha corretamente")
	@Size(min = 5, max = 50, message = "'${validatedValue}' precisa está entre '${min}' e '${max}' caracteres!")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Não pode ser vazio!")
	@CPF(message = "'${validatedValue}' invalido!")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotBlank(message = "Preencha corretamente")
	@Size(min = 5, max = 50, message = "'${validatedValue}' precisa está entre '${min}' e '${max}' caracteres!")
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@NotNull(message = "Preencha corretamente")
	@Past(message = "Data '${validatedValue}' invalida!")
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
