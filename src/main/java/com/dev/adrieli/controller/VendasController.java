package com.dev.adrieli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.adrieli.entity.Vendas;
import com.dev.adrieli.service.VendasService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/vendas")
public class VendasController {
	@Autowired
	VendasService vendasService;
	
	@GetMapping(value = "/")
	@CrossOrigin("http://localhost:3000")
	public List<Vendas> buscarTodos() {
		return vendasService.buscarTodos();
	}
	
	@PostMapping(value = "/")
	@CrossOrigin("http://localhost:3000")
	public Vendas salvar(@RequestBody Vendas vendas) {
		if(vendas.getDesconto() != 0) {
			Double total = vendas.getValorVenda() - (vendas.getValorVenda() * (vendas.getComissao()));
			vendas.setTotalVenda(total);
		} else {
			vendas.setTotalVenda(vendas.getValorVenda());
		}
		vendas.setComissao(vendas.getValorVenda()*0.15);
		return vendasService.salvar(vendas);
	}
	
	@PutMapping(value = "/")
	@CrossOrigin("http://localhost:3000")
	public Vendas alterar(@RequestBody Vendas vendas) {
		return vendasService.alterar(vendas);
	}
	
	@DeleteMapping(path = "/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		vendasService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
