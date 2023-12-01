package com.example.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.EnderecoDTO;

@FeignClient(name = "viaCepProxyFeign", url = "https://viacep.com.br/ws")
public interface ViaCepProxyFeign {
	
	@GetMapping("/{cep}/json")
	public EnderecoDTO getEnderecoDTO(@PathVariable("cep") String cep);

}
