package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EnderecoDTO;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@GetMapping("/{cep}")
	public EnderecoDTO buscarPorCep(@PathVariable String cep) {
		
		final var endereco = new EnderecoDTO();
		endereco.setLogradouro("Rua X");
		endereco.setBairro("Bairro Y");
		endereco.setLocalidade("Cidade Z");
		endereco.setUf("UF");
		
		return endereco;
	}

}
