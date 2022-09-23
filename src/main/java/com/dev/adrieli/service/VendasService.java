package com.dev.adrieli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.adrieli.entity.Vendas;
import com.dev.adrieli.repository.VendasRepository;

@Service
public class VendasService {
	@Autowired
	VendasRepository vendasRepository;
	
	public List<Vendas> buscarTodos(){
		return vendasRepository.findAll();
	}
	
	public Vendas salvar(Vendas vendas) {
		return vendasRepository.save(vendas);
	}
	
	public Vendas alterar(Vendas vendas) {
		return vendasRepository.save(vendas);
	}
	
	public void deletar(Long id) {
		Vendas vendas = vendasRepository.findById(id).get();
		vendasRepository.delete(vendas);
	}
}
