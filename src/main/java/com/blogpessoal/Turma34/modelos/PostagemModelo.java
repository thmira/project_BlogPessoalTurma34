package com.blogpessoal.Turma34.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe espelho da tabela postagem no banco db_blogpessoal.
 *
 * @author Turma34
 * @since 1.0
 *
 */
@Entity
public class PostagemModelo {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idPostagem;
    private @NotBlank String titulo;
    private @NotBlank String descricao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPostagem = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"minhasPostagens"})
    private UsuarioModelo criador;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    @JsonIgnoreProperties({"postagens"})
    private TemaModelo temaRelacionado;

    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public UsuarioModelo getCriador() {
        return criador;
    }

    public void setCriador(UsuarioModelo criador) {
        this.criador = criador;
    }

    public TemaModelo getTemaRelacionado() {
        return temaRelacionado;
    }

    public void setTemaRelacionado(TemaModelo temaRelacionado) {
        this.temaRelacionado = temaRelacionado;
    }

}