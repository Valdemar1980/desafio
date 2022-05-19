package com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiSwapiPessoaDTO {

	@JsonCreator
	public ApiSwapiPessoaDTO(@JsonProperty("nome") String name, @JsonProperty("altura") String height,
			@JsonProperty("massa") String mass, @JsonProperty("cor_cabelo") String hair_color,
			@JsonProperty("cor_pele") String skin_color, @JsonProperty("cor_olhos") String eye_color,
			@JsonProperty("ano_nascimento") String birth_year, @JsonProperty("sexo") String gender,
			@JsonProperty("naturalidade") String homeworld, @JsonProperty("filmes") ArrayList<String> films,
			@JsonProperty("especies") ArrayList<String> species, @JsonProperty("veiculos") ArrayList<String> vehicles,
			@JsonProperty("naves") ArrayList<String> starships, @JsonProperty("criado") Date created,
			@JsonProperty("editado") Date edited, @JsonProperty("url") String url

	) {
		this.name = name;
		this.height = height;
		this.mass = mass;
		this.hair_color = hair_color;
		this.skin_color = skin_color;
		this.eye_color = eye_color;
		this.birth_year = birth_year;
		this.gender = gender;
		this.homeworld = homeworld;
		this.films = films;
		this.species = species;
		this.vehicles = vehicles;
		this.starships = starships;
		this.created = created;
		this.edited = edited;
		this.url = url;

	}

	String name;
	String height;
	String mass;
	String hair_color;
	String skin_color;
	String eye_color;
	String birth_year;
	String gender;
	String homeworld;
	ArrayList<String> films;
	ArrayList<String> species;
	ArrayList<String> vehicles;
	ArrayList<String> starships;
	Date created;
	Date edited;
	String url;
}
