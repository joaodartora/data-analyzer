package com.joaodartora.core.challenge.model;

public class Salesman {

	private String cpf;
	private String name;
	private float salary;
	private double totalValueSales;
	
	public Salesman(String cpf, String name, float salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}
	
	public Salesman(String name, double totalValueSales) {
		this.name = name;
		this.totalValueSales = totalValueSales;
	}

	public Salesman() {}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}

	public double getTotalValueSales() {
		return totalValueSales;
	}

	public void setTotalValueSales(double totalValueSales) {
		this.totalValueSales = totalValueSales;
	}
}
