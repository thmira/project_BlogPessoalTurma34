package com.blogpessoal.Turma34.controladores;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.blogpessoal.Turma34.modelos.UsuarioModelo;
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

import com.blogpessoal.Turma34.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControlador {

	private @Autowired UsuarioRepositorio repositorio;

	@GetMapping("/todos")
	public ResponseEntity<List<UsuarioModelo>> pegarTodos() {
		List<UsuarioModelo> objetoLista = repositorio.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<UsuarioModelo> pegarId(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<UsuarioModelo> objetoOptional = repositorio.findById(idUsuario);

		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<UsuarioModelo> salvar(@Valid @RequestBody UsuarioModelo novoUsuario) {
		return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioModelo> atualizar(@Valid @RequestBody UsuarioModelo novoUsuario) {
		return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<UsuarioModelo> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<UsuarioModelo> objetoOptional = repositorio.findById(idUsuario);

		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
