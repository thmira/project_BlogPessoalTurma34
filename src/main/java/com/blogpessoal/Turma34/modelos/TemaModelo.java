package com.blogpessoal.Turma34.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TemaModelo {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema;
    private String titulo;
    private String descricao;
}
