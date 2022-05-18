package com.desafio.lojadomecanico.desafiolojadomecanico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapiFilmeDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapiPessoaDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapiPlanetaDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.services.SwApiService;

@RestController
@RequestMapping(value = "/recurso")
public class SwApiResource {

	@Autowired
	private final SwApiService service;
	
	public SwApiResource(SwApiService service) {
		this.service = service;
	}
	
	/**
	 * Lista todos os filmes da Swapi.
	 * 
	 * @return List<ApiSwapiFilmesDTO>.
	 */
	@RequestMapping(value = "/filmes", method = RequestMethod.GET)
	public ResponseEntity<List<ApiSwapiFilmeDTO>>  listarFilmes() {
		List<ApiSwapiFilmeDTO> lista = service.listarFilmes();
		 
		return ResponseEntity.ok(lista);
	}
	
	
	/**
	 * Retorna um filme conforme parametro id.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="filmes/{id}", method=RequestMethod.GET)
	public ResponseEntity<ApiSwapiFilmeDTO> findFilme(@PathVariable Integer id) {
		ApiSwapiFilmeDTO obj = service.findFilme(id);
		
		return ResponseEntity.ok(obj);
	}
	
	
	/**
	 * Lista todas as pessoas da Swapi.
	 * 
	 * @return List<ApiSwapiPessoasDTO>.
	 */
	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public ResponseEntity<List<ApiSwapiPessoaDTO>>  listarPessoas() {
		List<ApiSwapiPessoaDTO> lista = service.listarPessoas();
		 
		return ResponseEntity.ok(lista);
	}
	
	/**
	 * Retorna uma pessoa conforme parametro id.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="pessoas/{id}", method=RequestMethod.GET)
	public ResponseEntity<ApiSwapiPessoaDTO> findPessoa(@PathVariable Integer id) {
		ApiSwapiPessoaDTO obj = service.findPessoa(id);
		
		return ResponseEntity.ok(obj);
	}
	
	
	/**
	 * Lista todos os planetas da Swapi.
	 * 
	 * @return List<ApiSwapiPlanetaDTO>.
	 */
	@RequestMapping(value = "/planetas", method = RequestMethod.GET)
	public ResponseEntity<List<ApiSwapiPlanetaDTO>>  listarPlanetas() {
		List<ApiSwapiPlanetaDTO> lista = service.listarPlanetas();
		 
		return ResponseEntity.ok(lista);
	}
	
	/**
	 * Retorna uma pessoa conforme parametro id.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="planetas/{id}", method=RequestMethod.GET)
	public ResponseEntity<ApiSwapiPlanetaDTO> findPlaneta(@PathVariable Integer id) {
		ApiSwapiPlanetaDTO obj = service.findPlaneta(id);
		
		return ResponseEntity.ok(obj);
	}

}
