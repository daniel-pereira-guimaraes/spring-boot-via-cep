package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EnderecoDTO;
import com.example.proxy.ViaCepProxyFeign;
import com.example.proxy.ViaCepProxyRestTemplate;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoController.class);
	
	@Autowired
	private ViaCepProxyRestTemplate viaCepProxyRestTemplate;
	
	@Autowired
	private ViaCepProxyFeign viaCepProxyFeign; 
	
	@GetMapping("/{cep}/{proxy}")
	public EnderecoDTO buscarPorCepRestTemplate(
			@PathVariable String cep,
			@PathVariable int proxy) {
		
		if (proxy == 0) {
			LOGGER.info("Busca de CEP usando RestTemplate: {}", cep);
			return viaCepProxyRestTemplate.buscarPorCep(cep);
		} else {
			LOGGER.info("Busca de CEP usando Feign: {}", cep);
			return viaCepProxyFeign.getEnderecoDTO(cep);
		}
	}

}
