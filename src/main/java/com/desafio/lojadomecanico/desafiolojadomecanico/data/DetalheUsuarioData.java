package com.desafio.lojadomecanico.desafiolojadomecanico.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.desafio.lojadomecanico.desafiolojadomecanico.domain.Usuario;

public class DetalheUsuarioData implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final  Optional<Usuario> usuario;
	
	
	
	public DetalheUsuarioData(Optional<Usuario> usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return  usuario.orElse(new Usuario()).getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.orElse(new Usuario()).getUser();
	}

	
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
