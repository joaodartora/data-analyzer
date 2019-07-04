package com.joaodartora.core.temafinal.model;

public class Customer {

	private String cnpj;
	private String name;
	private String businessArea;
	
	public Customer(String cnpj, String name, String businessArea) {
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}
	
	public Customer() {}
}
