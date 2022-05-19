package com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto;

import java.util.List;
import lombok.Data;


@Data
public class ApiSwapResponsePlanetaDTO  {

	int count;
	Object next;
	Object previous;
	List<ApiSwapiPlanetaDTO> results;
}
