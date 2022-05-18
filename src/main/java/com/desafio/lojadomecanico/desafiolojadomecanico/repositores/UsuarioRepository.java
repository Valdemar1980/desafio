package com.desafio.lojadomecanico.desafiolojadomecanico.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.lojadomecanico.desafiolojadomecanico.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Optional<Usuario> findByUser(String user);

}
