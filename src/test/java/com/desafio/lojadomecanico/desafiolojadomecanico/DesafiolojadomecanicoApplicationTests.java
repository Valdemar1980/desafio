package com.desafio.lojadomecanico.desafiolojadomecanico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto.ApiSwapiFilmeDTO;
import com.desafio.lojadomecanico.desafiolojadomecanico.services.SwApiService;

@SpringBootTest
class DesafiolojadomecanicoApplicationTests {
	@MockBean
	private SwApiService servico;

	@Test
	void contextLoads() {
	}

	@Test
	public void retornarListaFilmeOk() throws Exception {

		this.servico.listarFilmes();
		List<ApiSwapiFilmeDTO> lista = new ArrayList<ApiSwapiFilmeDTO>();
		lista.add(new ApiSwapiFilmeDTO());
		when(this.servico.listarFilmes()).thenReturn(lista);

		assertEquals(false, lista.isEmpty());
	}

}
