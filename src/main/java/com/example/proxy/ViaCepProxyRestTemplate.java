package com.example.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.dto.EnderecoDTO;

@Component
public class ViaCepProxyRestTemplate {
	
	@Value("${viacep.url}")
	private String url;
	
	public EnderecoDTO buscarPorCep(String cep) {
		final var finalUrl = String.format(url, cep);
		return new RestTemplate().getForEntity(finalUrl, EnderecoDTO.class).getBody();
	}

}
