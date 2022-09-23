package com.dev.adrieli.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "venda")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class Vendas {
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 private String nomeCliente;
	 private int cpf;
	 private String descricaoVeiculo;
	 private double valorCompra;
	 private double valorVenda;
	 private double desconto;
	 private double totalVenda;
	 private double comissao;
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date dataCadastro = new Date();
}
