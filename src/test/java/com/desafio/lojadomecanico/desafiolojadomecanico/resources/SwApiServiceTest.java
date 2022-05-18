package com.desafio.lojadomecanico.desafiolojadomecanico.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.desafio.lojadomecanico.desafiolojadomecanico.services.SwApiService;


@SpringBootTest
@AutoConfigureMockMvc
public class SwApiServiceTest {

    @Autowired
    private MockMvc mockMvc;	
			
	@MockBean
	private SwApiService servico;		
		
//	@Test
	public void deveRetornarStatusOk() throws Exception {
		
		this.servico.listarFilmes();
		
		this.mockMvc.perform(get("https://swapi.dev/api/filmes/")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
}

