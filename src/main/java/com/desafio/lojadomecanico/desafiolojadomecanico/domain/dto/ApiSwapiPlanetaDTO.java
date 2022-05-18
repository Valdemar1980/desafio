package com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiSwapiPlanetaDTO {

	public ApiSwapiPlanetaDTO(@JsonProperty("nome") String name, @JsonProperty("perido_rotacao") String rotation_period,
			@JsonProperty("perido_orbital") String orbital_period, @JsonProperty("diametro") String diameter,
			@JsonProperty("clima") String climate, @JsonProperty("gravidade") String gravity,
			@JsonProperty("terreno") String terrain, @JsonProperty("agua_superficie") String surface_water,
			@JsonProperty("populacao") String population, @JsonProperty("moradores") ArrayList<String> residents,
			@JsonProperty("filmes") ArrayList<String> films, @JsonProperty("criado") Date created,
			@JsonProperty("editado") Date edited, 
			@JsonProperty("url")String url) {
		super();
		this.name = name;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.population = population;
		this.residents = residents;
		this.films = films;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	String name;
	String rotation_period;
	String orbital_period;
	String diameter;
	String climate;
	String gravity;
	String terrain;
	String surface_water;
	String population;
	ArrayList<String> residents;
	ArrayList<String> films;
	Date created;
	Date edited;
	String url;
}
