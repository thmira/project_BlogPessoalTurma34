package com.blogpessoal.Turma34.servicos;

import com.blogpessoal.Turma34.modelos.UsuarioModelo;
import com.blogpessoal.Turma34.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicos {

    private @Autowired UsuarioRepositorio repositorio;

    /**
     * Metodo utilizado para cadastrar usuario validando duplicidade de email no banco
     */
    public Optional<?> cadastrarUsuario(UsuarioModelo usuarioParaCadastrar){
        return repositorio.findByEmail(usuarioParaCadastrar.getEmail()).map(usuarioExistente -> {
            return Optional.empty();
        }).orElseGet(() ->{
            return Optional.ofNullable(repositorio.save(usuarioParaCadastrar));
        });
    }
}
