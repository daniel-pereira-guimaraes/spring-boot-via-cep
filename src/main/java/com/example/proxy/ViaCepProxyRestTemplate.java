package com.example.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.dto.EnderecoDTO;

@Component
public class ViaCepProxyRestTemplate {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ViaCepProxyRestTemplate.class);
	
	@Value("${viacep.url}")
	private String url;
	
	public EnderecoDTO buscarPorCep(String cep) {
		
		final var finalUrl = String.format(url, cep);
		LOGGER.info("Requisição {}", finalUrl);
		
		return new RestTemplate().getForEntity(finalUrl, EnderecoDTO.class).getBody();
	}

}
