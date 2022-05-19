package com.desafio.lojadomecanico.desafiolojadomecanico.services;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapResponseFilmeDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapResponsePessoaDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapResponsePlanetaDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapiFilmeDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapiPessoaDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapiPlanetaDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.exceptions.ObjectNotFoundException;

@Component
public class SwApiService {

	private static final String METODO_SERVER = "https://swapi.dev";
	private static final String PATH_PLANETS = "api/planets/";
	private static final String PATH_FILM = "api/films/";
	private static final String PATH_PEOPLE = "api/people/";
	
	private WebClient client;

	/**
	 * Instancia objeto para consumo.
	 */
	@PostConstruct
	public void fooInit() {
		this.client = WebClient.create(METODO_SERVER);
	}

	/**
	 * Lista todos os filmes da Swapi.
	 * 
	 * @return List<ApiSwapiFilmesDTO>.
	 */
	public List<ApiSwapiFilmeDTO> listarFilmes() {
		ApiSwapResponseFilmeDTO retorno;
		try {
			retorno = client.get().uri(PATH_FILM).retrieve().bodyToMono(ApiSwapResponseFilmeDTO.class).block();
		} catch (WebClientResponseException e) {
			throw new RuntimeException("A api SWAPI não retornou nenhum filme.");
		}

		return retorno.getResults();
	}

	/**
	 * Retorna um filme conforme id parametro.
	 * 
	 * @param id
	 * @return
	 */
	public ApiSwapiFilmeDTO findFilme(Integer id) {
		ApiSwapiFilmeDTO retorno;
		try {
			retorno = client.get().uri(PATH_FILM + "/{id}", id).retrieve().bodyToMono(ApiSwapiFilmeDTO.class).block();
		} catch (WebClientResponseException e) {
			throw new ObjectNotFoundException("A api SWAPI não possui filme com esse id.");
		}

		return retorno;
	}

	/**
	 * Lista todas as pessoas da Swapi.
	 * 
	 * @return List<ApiSwapiPessoasDTO>.
	 */
	public List<ApiSwapiPessoaDTO> listarPessoas() {
		ApiSwapResponsePessoaDTO retorno;
		try {
			retorno = client.get().uri(PATH_PEOPLE).retrieve().bodyToMono(ApiSwapResponsePessoaDTO.class).block();
		} catch (WebClientResponseException e) {
			throw new RuntimeException("A api SWAPI não retornou nenhuma pessoa.");
		}

		return retorno.getResults();
	}

	/**
	 * Retorna uma pessoa conforme id parametro.
	 * 
	 * @param id
	 * @return
	 */
	public ApiSwapiPessoaDTO findPessoa(Integer id) {
		ApiSwapiPessoaDTO retorno;
		try {
			retorno = client.get().uri(PATH_PEOPLE + "/{id}", id).retrieve().bodyToMono(ApiSwapiPessoaDTO.class)
					.block();
		} catch (WebClientResponseException e) {
			throw new ObjectNotFoundException("A api SWAPI não possui pessoa com esse id.");
		}

		return retorno;
	}

	/**
	 * Lista todos os planetas da Swapi.
	 * 
	 * @return List<ApiSwapiPlanetaDTO>.
	 */
	public List<ApiSwapiPlanetaDTO> listarPlanetas() {
		ApiSwapResponsePlanetaDTO retorno;
		try {
			retorno = client.get().uri(PATH_PLANETS).retrieve().bodyToMono(ApiSwapResponsePlanetaDTO.class).block();

		} catch (WebClientResponseException e) {
			throw new RuntimeException("A api SWAPI não retornou nenhum planeta.");
		}

		return retorno.getResults();
	}

	/**
	 * Retorna um planeta conforme id parametro.
	 * 
	 * @param id
	 * @return
	 */
	public ApiSwapiPlanetaDTO findPlaneta(Integer id) {
		ApiSwapiPlanetaDTO retorno;
		try {
			retorno = client.get().uri(PATH_PLANETS + "/{id}", id).retrieve().bodyToMono(ApiSwapiPlanetaDTO.class)
					.block();
		} catch (WebClientResponseException e) {
			throw new ObjectNotFoundException("A api SWAPI não possui planeta com esse id.");
		}

		return retorno;
	}

}
