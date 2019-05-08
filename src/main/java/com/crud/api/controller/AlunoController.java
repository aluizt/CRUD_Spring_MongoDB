package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.model.Aluno;
import com.crud.api.model.DTO.AlunoDTO;
import com.crud.api.services.AlunoService;

@RestController
@RequestMapping(path="/api/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> listaTodos(){
		return ResponseEntity.ok(this.alunoService.listarTodos());
	}
	
	@GetMapping(path="/dao")
	public ResponseEntity<List<AlunoDTO>> listaTodosDao(){
		return ResponseEntity.ok(this.alunoService.listarTodosDao());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<AlunoDTO> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(this.alunoService.listarId(id));
	}
	
	@PostMapping
	public ResponseEntity<Aluno> incluir( @RequestBody Aluno aluno){
		return ResponseEntity.ok(this.alunoService.incluir(aluno));
	}

	@PutMapping(path=("/{id}"))
	public ResponseEntity<Aluno> alterar( @PathVariable(name="id") String id, @RequestBody Aluno aluno){
		aluno.setId(id);
		return ResponseEntity.ok(this.alunoService.alterar(id, aluno));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Integer> deletar(@PathVariable(name="id") String id){
		 this.alunoService.remover(id);
		 return ResponseEntity.ok(1);
	}
}
