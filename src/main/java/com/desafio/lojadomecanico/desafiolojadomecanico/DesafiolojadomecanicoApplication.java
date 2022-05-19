package com.desafio.lojadomecanico.desafiolojadomecanico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.Usuario;
import com.desafio.lojadomecanico.desafiolojadomecanico.repositores.UsuarioRepository;

@SpringBootApplication
public class DesafiolojadomecanicoApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository service;

	public static void main(String[] args) {
		SpringApplication.run(DesafiolojadomecanicoApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder;
	}

	/**
	 * Insere o primeiro usuario com login no banco H2,
	 * Ao subir a aplicação.
	 */
	@Override
	public void run(String... args) throws Exception {
		Usuario entidade = new Usuario();
		entidade.setUser("valdemar.xavier");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		entidade.setPassword(encoder.encode("1980"));
		service.save(entidade);
	}
}
