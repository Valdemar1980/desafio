package com.desafio.lojadomecanico.desafiolojadomecanico.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.desafio.lojadomecanico.desafiolojadomecanico.data.DetalheUsuarioData;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAutenticarFilter extends  UsernamePasswordAuthenticationFilter {
	
	private final AuthenticationManager authenticationManager;
	
	
	
	public static final String TOKEN_SENHA = "fac110e6-f5b0-480c-922f-e276adf68ee2";
	
	public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	//Autentica
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUser(), usuario.getPassword(),new ArrayList<>()));
		} catch  (IOException e) {
			throw new RuntimeException("Falha ao autenticar  usuario", e);
		}
	}
	
	//Sucesso na autenticacao,  gera-se o token
	@Override
	public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
		
		String token = JWT.create()
				.withSubject(usuarioData.getUsername())
				.sign(Algorithm.HMAC512(TOKEN_SENHA));
		
		response.getWriter().write(token);
		response.getWriter().flush();
		
	}

}
