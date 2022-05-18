package com.desafio.lojadomecanico.desafiolojadomecanico.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.desafio.lojadomecanico.desafiolojadomecanico.data.DetalheUsuarioData;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.Usuario;
import com.desafio.lojadomecanico.desafiolojadomecanico.repositores.UsuarioRepository;


@Component
public class DetalheUsuarioService implements UserDetailsService{

	
	private  final UsuarioRepository repo;
	
	public DetalheUsuarioService(UsuarioRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repo.findByUser(username);
		
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuario [" + username  + "] nao encontrado");
		}
		return new DetalheUsuarioData(usuario);
	}
	
}
