package com.higoramorim.modulo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Aluno;

@RestController
@RequestMapping("/alunos")
public class CadastraAlunoRest {

	private List<Aluno> alunos;

	public CadastraAlunoRest() {
		this.alunos = new ArrayList<>();

	}

	@GetMapping
	public List<Aluno> findAll() {
		return alunos;
	}

	@GetMapping("/filtrar-por-nome")
	public List<Aluno> findByFilterName(@RequestParam(required = false) String nome) {
		if (nome != null) {
			return alunos.stream().filter(msg -> msg.getNome().contains(nome)).collect(Collectors.toList());
		}
		return null;
	}

	@GetMapping("/filtrar-por-idade")
	public List<Aluno> findByFilterAge(@RequestParam(required = false) String idade) {
		if (idade != null) {
			return alunos.stream().filter(msg -> msg.getIdade().contains(idade)).collect(Collectors.toList());
		}
		return null;
	}

	@GetMapping("/{id}")
	public Aluno findById(@PathVariable("id") Integer id) {
		return this.alunos.stream().filter(msg -> msg.getId().equals(id)).findFirst().orElse(null);
	}

	@PostMapping
	public ResponseEntity<Integer> add(@RequestBody final Aluno aluno) {
		if (aluno.getId() == null) {
			aluno.setId(alunos.size() + 1);
		}
		alunos.add(aluno);
		return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
	}

	@PutMapping("/atualiza-nome")
	public ResponseEntity updateName(@RequestBody final Aluno aluno) {
		alunos.stream().filter(al -> al.getId().equals(aluno.getId())).forEach(al -> al.setNome(aluno.getNome()));
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/atualiza-idade")
	public ResponseEntity updateAge(@RequestBody final Aluno aluno) {
		alunos.stream().filter(al -> al.getId().equals(aluno.getId())).forEach(al -> al.setIdade(aluno.getIdade()));
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		alunos.removeIf(al -> al.getId().equals(id));
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
