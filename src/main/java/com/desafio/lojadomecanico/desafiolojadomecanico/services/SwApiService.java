package com.desafio.lojadomecanico.desafiolojadomecanico.services;

import java.util.List;
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class SwApiService {

	private static final String METODO_SERVER = "https://swapi.dev";
	private static final String PATH_PLANETS= "api/planets/";
	private static final String PATH_FILM = "api/films/";
	private static final String PATH_PEOPLE= "api/people/";
	/**
	 * Objeto para parse.
	 */
	private static ObjectMapper objectMapper;

	/**
	 * Lista todos os filmes da Swapi.
	 * 
	 * @return List<ApiSwapiFilmesDTO>.
	 */
	public List<ApiSwapiFilmeDTO> listarFilmes() {
		ApiSwapResponseFilmeDTO retorno;
		try {
			WebClient client = WebClient.create(METODO_SERVER);
			String response = client.get().uri(PATH_FILM).retrieve().bodyToMono(String.class).block();

			retorno = toObject(response, ApiSwapResponseFilmeDTO.class);

		} catch (WebClientResponseException e) {
			throw new RuntimeException("A api SWAPI não retornou nenhum filme.");
		}

		return retorno.getResults();
	}

	/**
	 * Retorna um filme conforme parametro.
	 * 
	 * @param id
	 * @return
	 */
	public ApiSwapiFilmeDTO findFilme(Integer id) {
		ApiSwapiFilmeDTO retorno;
		try {
			WebClient client = WebClient.create(METODO_SERVER);
			String response = client.get().uri(PATH_FILM + id).retrieve().bodyToMono(String.class).block();

			retorno = toObject(response, ApiSwapiFilmeDTO.class);
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
			WebClient client = WebClient.create(METODO_SERVER);
			String response = client.get().uri(PATH_PEOPLE).retrieve().bodyToMono(String.class).block();

			retorno = toObject(response, ApiSwapResponsePessoaDTO.class);

		} catch (WebClientResponseException e) {
			throw new RuntimeException("A api SWAPI não retornou nenhuma pessoa.");
		}

		return  retorno.getResults();
	}

	/**
	 * Retorna uma pessoa conforme parametro.
	 * 
	 * @param id
	 * @return
	 */
	public ApiSwapiPessoaDTO findPessoa(Integer id) {
		ApiSwapiPessoaDTO retorno;
		try {
			WebClient client = WebClient.create(METODO_SERVER);
			String response = client.get().uri(PATH_PEOPLE + id).retrieve().bodyToMono(String.class).block();

			retorno = toObject(response, ApiSwapiPessoaDTO.class);
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
			WebClient client = WebClient.create(METODO_SERVER);
			String response = client.get().uri(PATH_PLANETS).retrieve().bodyToMono(String.class).block();

			retorno = toObject(response, ApiSwapResponsePlanetaDTO.class);

		} catch (WebClientResponseException e) {
			throw new RuntimeException("A api SWAPI não retornou nenhum planeta.");
		}

		return  retorno.getResults();
	}

	/**
	 * Retorna um planeta conforme parametro.
	 * 
	 * @param id
	 * @return
	 */
	public ApiSwapiPlanetaDTO findPlaneta(Integer id) {
		ApiSwapiPlanetaDTO retorno;
		try {
			WebClient client = WebClient.create(METODO_SERVER);
			String response = client.get().uri(PATH_PLANETS + id).retrieve().bodyToMono(String.class).block();

			retorno = toObject(response, ApiSwapiPlanetaDTO.class);
		} catch (WebClientResponseException e) {
			throw new ObjectNotFoundException("A api SWAPI não possui planeta com esse id.");
		}
		
		return retorno;
	}
	
	
	
	/**
	 * Recebe String e processa parse para o tipo de objeto valueType.
	 * 
	 * @param <T>
	 * @param json
	 * @param valueType
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> valueType) {
		try {
			return objectMapper.readValue(json, valueType);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao transformar json em objeto", e);
		}
	}


	/**
	 * Instancia objeto para parse.
	 */
	static {
		try {
			objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
					.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
					.enable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID)
					.setSerializationInclusion(JsonInclude.Include.NON_NULL)
					.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu uma exceção na criação da instância singleton");
		}
	}

}
