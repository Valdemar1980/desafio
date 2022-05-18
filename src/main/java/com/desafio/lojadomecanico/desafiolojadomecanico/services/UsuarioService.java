package com.desafio.lojadomecanico.desafiolojadomecanico.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.lojadomecanico.desafiolojadomecanico.domain.Usuario;
import com.desafio.lojadomecanico.desafiolojadomecanico.repositores.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	private final PasswordEncoder encoder;
	
	public UsuarioService(UsuarioRepository repo, PasswordEncoder encoder) {
		super();
		this.repo = repo;
		this.encoder = encoder;
	}

	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj.setPassword(encoder.encode(obj.getPassword()));
		obj = repo.save(obj);

		return obj;
	}

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! id: " + id + ", Tipo: " + Usuario.class.getName(), null));
	}

	public Usuario update(Usuario obj) {
		obj.setPassword(encoder.encode(obj.getPassword()));
		return repo.save(obj);
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}

	public Optional<Usuario> findByUser(String user) {
		return repo.findByUser(user);
	}

	public void insertCriptografado(Usuario entidade) {
		entidade.setId(null);

		entidade = repo.save(entidade);

	}

}
