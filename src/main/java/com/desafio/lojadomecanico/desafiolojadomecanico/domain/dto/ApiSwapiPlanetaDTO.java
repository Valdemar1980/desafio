package com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto;

import java.util.ArrayList;
import java.util.Date;

public class ApiSwapiPlanetaDTO {
    
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
	
     public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRotation_period() {
		return rotation_period;
	}
	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}
	public String getOrbital_period() {
		return orbital_period;
	}
	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getGravity() {
		return gravity;
	}
	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getSurface_water() {
		return surface_water;
	}
	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public ArrayList<String> getResidents() {
		return residents;
	}
	public void setResidents(ArrayList<String> residents) {
		this.residents = residents;
	}
	public ArrayList<String> getFilms() {
		return films;
	}
	public void setFilms(ArrayList<String> films) {
		this.films = films;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getEdited() {
		return edited;
	}
	public void setEdited(Date edited) {
		this.edited = edited;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
