package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EnderecoService;
import com.example.dto.EnderecoDTO;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping("/{cep}")
	public EnderecoDTO buscarPorCep(@PathVariable String cep) {
		
		return service.buscarPorCep(cep);
	}

}
