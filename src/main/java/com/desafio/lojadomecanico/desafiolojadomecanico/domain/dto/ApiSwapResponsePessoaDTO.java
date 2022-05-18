package com.desafio.lojadomecanico.desafiolojadomecanico.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiSwapResponsePessoaDTO  {

	int count;
	Object next;
	Object previous;
	List<ApiSwapiPessoaDTO> results;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Object getNext() {
		return next;
	}
	public void setNext(Object next) {
		this.next = next;
	}
	public Object getPrevious() {
		return previous;
	}
	public void setPrevious(Object previous) {
		this.previous = previous;
	}
	public List<ApiSwapiPessoaDTO> getResults() {
		return results;
	}
	public void setResults(List<ApiSwapiPessoaDTO> results) {
		this.results = results;
	}

}
