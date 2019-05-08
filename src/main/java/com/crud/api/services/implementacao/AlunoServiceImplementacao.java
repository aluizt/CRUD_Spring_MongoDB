package com.crud.api.services.implementacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.api.model.Aluno;
import com.crud.api.model.DTO.AlunoDTO;
import com.crud.api.repositories.AlunoRepository;
import com.crud.api.services.AlunoService;

@Repository
public class AlunoServiceImplementacao implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public List<Aluno> listarTodos() {
		return this.alunoRepository.findAll();
	}
	
	@Override
	public List<AlunoDTO> listarTodosDao() {
		
		List<Aluno> alunos = this.alunoRepository.findAll();
		List<AlunoDTO> alunosDao = new ArrayList<AlunoDTO>();
		
		alunos.forEach(aluno -> alunosDao.add(new AlunoDTO(aluno.getId(),aluno.getNome(),aluno.getMatricula())));
		
		return alunosDao;
	}

	
	@Override
	public AlunoDTO listarId(String id) {
		Optional<Aluno> op= this.alunoRepository.findById(id);
		Aluno aluno =null;
		AlunoDTO alunoDTO = new AlunoDTO();
		
		if(op.isPresent()) {
			 aluno=(Aluno) op.get();
			 alunoDTO.setId(aluno.getId());
			 alunoDTO.setMatricula(aluno.getMatricula());
			 alunoDTO.setNome(aluno.getNome());
			 return alunoDTO;
		}
		return alunoDTO;
		
	}

	@Override
	public Aluno incluir(Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}
	
	@Override
	public Aluno alterar(String id, Aluno aluno) {
		aluno.setId(id);
		return this.alunoRepository.save(aluno);
	}

	@Override
	public int remover(String id) {
		this.alunoRepository.deleteById(id);
        return 1;
	}

	@Override
	public Object listaPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}





}
