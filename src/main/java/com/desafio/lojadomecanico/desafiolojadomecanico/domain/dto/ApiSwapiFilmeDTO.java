package com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiSwapiFilmeDTO {

	@JsonCreator
	public ApiSwapiFilmeDTO(@JsonProperty("titulo") String title, @JsonProperty("episodio_id") Integer episode_id,
			@JsonProperty("abertura_rastreamento") String opening_crawl, @JsonProperty("diretor") String director,
			@JsonProperty("produtor") String producer, @JsonProperty("data de lançamento") String release_date,
			@JsonProperty("criado") String created, @JsonProperty("editado") String edited,
			@JsonProperty("URL") String url, @JsonProperty("personagens") List<String> characters,
			@JsonProperty("planetas") List<String> planets, @JsonProperty("naves_estelares") List<String> starships,
			@JsonProperty("veiculos") List<String> vehicles, @JsonProperty("especies") List<String> species) {

		this.title = title;
		this.episode_id = episode_id;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
		this.created = created;
		this.edited = edited;
		this.url = url;
		this.characters = characters;
		this.planets = planets;
		this.starships = starships;
		this.vehicles = vehicles;
		this.species = species;
	}

	String title;
	Integer episode_id;
	String opening_crawl;
	String director;
	String producer;
	String release_date;
	String created;
	String edited;
	String url;
	List<String> characters;
	List<String> planets;
	List<String> starships;
	List<String> vehicles;
	List<String> species;
}
