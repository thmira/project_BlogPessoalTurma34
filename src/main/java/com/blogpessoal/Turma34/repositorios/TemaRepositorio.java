package com.blogpessoal.Turma34.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.Turma34.modelos.TemaModelo;

import java.util.List;


/**
 *  Metodo utilizado para realizar pesquisa pela coluna tema na tabela tema
 */
@Repository
public interface TemaRepositorio extends JpaRepository<TemaModelo, Long>  {

    public List<TemaModelo> findAllByTemaContainingIgnoreCase(String tema);
}
