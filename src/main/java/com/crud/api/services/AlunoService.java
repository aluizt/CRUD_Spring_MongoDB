package com.crud.api.services;

import java.util.List;

import com.crud.api.model.Aluno;
import com.crud.api.model.DTO.AlunoDTO;

public interface AlunoService {

	public List<Aluno> listarTodos();
	
	public List<AlunoDTO> listarTodosDao();
	
	public AlunoDTO listarId(String id);
	
	public Aluno incluir(Aluno aluno);
	
	public Aluno alterar(String id, Aluno aluno);
	
	public int remover(String id);

	public Object listaPorId(String id);

	
}
