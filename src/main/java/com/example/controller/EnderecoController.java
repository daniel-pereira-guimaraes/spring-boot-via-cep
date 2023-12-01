package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EnderecoDTO;
import com.example.proxy.ViaCepProxyRestTemplate;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private ViaCepProxyRestTemplate viaCepProxyRestTemplate;
	
	@GetMapping("/{cep}/{proxy}")
	public EnderecoDTO buscarPorCepRestTemplate(
			@PathVariable String cep,
			@PathVariable int proxy) {
		
		if (proxy == 0) {
			return viaCepProxyRestTemplate.buscarPorCep(cep);
		} else {
			return null;
		}
	}

}
