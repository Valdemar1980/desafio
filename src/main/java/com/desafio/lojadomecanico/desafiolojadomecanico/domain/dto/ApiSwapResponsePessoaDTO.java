package com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto;

import java.util.List;

import lombok.Data;


@Data
public class ApiSwapResponsePessoaDTO  {

	int count;
	Object next;
	Object previous;
	List<ApiSwapiPessoaDTO> results;
	

}
