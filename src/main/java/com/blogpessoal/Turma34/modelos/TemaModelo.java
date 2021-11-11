package com.blogpessoal.Turma34.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe espelho da tabela tema no banco db_blogpessoal
 */
@Entity
public class TemaModelo {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTema;
    private @NotBlank String tema;

    @OneToMany(mappedBy = "temaRelacionado", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"temaRelacionado"})
    private List<PostagemModelo> postagens = new ArrayList<>();

    public Long getIdTema() {

        return idTema;
    }

    public void setIdTema(Long idTema) {

        this.idTema = idTema;
    }

    public String getTema() {

        return tema;
    }

    public void setTema(String tema) {

        this.tema = tema;
    }

    public List<PostagemModelo> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<PostagemModelo> postagens) {
        this.postagens = postagens;
    }
}
