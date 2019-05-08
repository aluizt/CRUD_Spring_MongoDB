package com.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.api.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

	
}
