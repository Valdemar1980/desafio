package com.desafio.lojadomecanico.desafiolojadomecanico.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.desafio.lojadomecanico.desafiolojadomecanico.services.DetalheUsuarioService;


@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter{
	
	private final DetalheUsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
	
	public JWTConfiguracao(DetalheUsuarioService usuarioService, PasswordEncoder passwordEncoder) {
		super();
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated()
		.and()
		.addFilter(new JWTAutenticarFilter(authenticationManager()))
		.addFilter(new JWTValidarFilter(authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	CorsConfigurationSource corsConfiguration() {
		final UrlBasedCorsConfigurationSource source =  new UrlBasedCorsConfigurationSource();
		CorsConfiguration  corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		source.registerCorsConfiguration("/**", corsConfiguration);
		
		return source;
	}
	
}