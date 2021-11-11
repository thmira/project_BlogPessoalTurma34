package com.blogpessoal.Turma34.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe espelho da tabela usuario no banco db_blogpessoal
 */

@Entity
public class UsuarioModelo {


    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
    private @NotBlank String nome;
    private @Email String email;
    private @NotBlank @Size(min = 5, max= 30) String senha;

    @OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"criador"})
    private List<PostagemModelo> minhasPostagens = new ArrayList<>();

    public Long getIdUsuario() {

        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {

        this.idUsuario = idUsuario;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    public List<PostagemModelo> getMinhasPostagens() {
        return minhasPostagens;
    }

    public void setMinhasPostagens(List<PostagemModelo> minhasPostagens) {
        this.minhasPostagens = minhasPostagens;
    }
}
