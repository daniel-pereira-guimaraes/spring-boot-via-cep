package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EnderecoDTO;
import com.example.proxy.ViaCepProxy;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private ViaCepProxy viaCepProxy;
	
	@GetMapping("/{cep}")
	public EnderecoDTO buscarPorCep(@PathVariable String cep) {
		
		return viaCepProxy.buscarPorCep(cep);
	}

}
