package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.EnderecoDTO;

@Service
public class EnderecoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoService.class);
	
	@Value("${viacep.url}")
	private String url;
	
	public EnderecoDTO buscarPorCep(String cep) {
		
		final var finalUrl = String.format(url, cep);
		LOGGER.info("Requisição {}", finalUrl);
		
		return new RestTemplate().getForEntity(finalUrl, EnderecoDTO.class).getBody();
	}

}
