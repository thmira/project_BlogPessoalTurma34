package com.blogpessoal.Turma34.controladores;

import com.blogpessoal.Turma34.modelos.TemaModelo;
import com.blogpessoal.Turma34.repositorios.TemaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tema")
@CrossOrigin("*")
public class TemaControlador {

    private @Autowired TemaRepositorio repositorio;

    @GetMapping("/todos")
    public ResponseEntity<List<TemaModelo>> pegarTodos() {
        List<TemaModelo> objetoLista = repositorio.findAll();

        if (objetoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(objetoLista);
        }
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<TemaModelo> pegarId(@PathVariable(value = "id_tema") Long idTema) {
        Optional<TemaModelo> objetoOptional = repositorio.findById(idTema);

        if (objetoOptional.isPresent()) {
            return ResponseEntity.status(200).body(objetoOptional.get());
        } else {
            return ResponseEntity.status(204).build();
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<TemaModelo> salvar(@Valid @RequestBody TemaModelo novoTema) {
        return ResponseEntity.status(201).body(repositorio.save(novoTema));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<TemaModelo> atualizar(@Valid @RequestBody TemaModelo novoTema) {
        return ResponseEntity.status(201).body(repositorio.save(novoTema));
    }

    @DeleteMapping("/deletar/{id_tema}")
    public ResponseEntity<TemaModelo> deletar(@PathVariable(value = "id_tema") Long idTema) {
        Optional<TemaModelo> objetoOptional = repositorio.findById(idTema);

        if (objetoOptional.isPresent()) {
            repositorio.deleteById(idTema);
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
}
