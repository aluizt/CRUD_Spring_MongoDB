package com.crud.api.model.DTO;

public class AlunoDTO {

	private String id;
	private String nome;
	private String matricula;
	
	public AlunoDTO() {}
	
	public AlunoDTO(String id, String nome, String matricula) {
		this.id=id;
		this.nome=nome;
		this.matricula=matricula;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
