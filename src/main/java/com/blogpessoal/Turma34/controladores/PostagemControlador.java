package com.blogpessoal.Turma34.controladores;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.Turma34.modelos.PostagemModelo;
import com.blogpessoal.Turma34.repositorios.PostagemRepositorio;


@RestController
@RequestMapping("/api/v1/postagem")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostagemControlador {

    private @Autowired PostagemRepositorio repositorio;

    @GetMapping("/todas")
    public ResponseEntity<List<PostagemModelo>> pegarTodas() {
        return ResponseEntity.ok(repositorio.findAll());

    }

    @GetMapping("/{id_postagem}")
    public ResponseEntity<PostagemModelo> pegarPorId(@PathVariable(value = "id_postagem") Long idPostagem) {
        return repositorio.findById(idPostagem).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.noContent().build());

    }

    @PostMapping("/salvar")
    public ResponseEntity<PostagemModelo> salvar(@Valid @RequestBody PostagemModelo novaPostagem) {
        return ResponseEntity.status(201).body(repositorio.save(novaPostagem));

    }

    @PutMapping("/atualizar")
    public ResponseEntity<PostagemModelo> atualizar(@Valid @RequestBody PostagemModelo novaPostagem) {
        return ResponseEntity.status(201).body(repositorio.save(novaPostagem));

    }

    @DeleteMapping("/deletar/{id_postagem}")
    public ResponseEntity<PostagemModelo> deletar(@PathVariable(value = "id_postagem") Long idPostagem) {
        Optional<PostagemModelo> objetoOptional = repositorio.findById(idPostagem);

        if (objetoOptional.isPresent()) {
            repositorio.deleteById(idPostagem);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
}