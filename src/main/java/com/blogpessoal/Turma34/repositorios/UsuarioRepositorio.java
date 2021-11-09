package com.blogpessoal.Turma34.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.Turma34.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	/**
	 * Metodo utilizado para realizar pesquisa pela coluna email na tb_usuario
	 */
	public Optional<Usuario> findByEmail(String email);
	
	/**
	 * Metodo utilizado para realizar pesquisa pela coluna nome na tb_usuario
	 */
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
