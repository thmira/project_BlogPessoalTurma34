package com.blogpessoal.Turma34.repositorios;

import java.util.List;
import java.util.Optional;

import com.blogpessoal.Turma34.modelos.UsuarioModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioModelo, Long> {
	
	/**
	 * Metodo utilizado para realizar pesquisa pela coluna email na tb_usuario
	 */
	public Optional<UsuarioModelo> findByEmail(String email);
	
	/**
	 * Metodo utilizado para realizar pesquisa pela coluna nome na tb_usuario
	 */
	public List<UsuarioModelo> findAllByNomeContainingIgnoreCase(String nome);
}
