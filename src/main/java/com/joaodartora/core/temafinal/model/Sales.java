package com.joaodartora.core.temafinal.model;

import java.util.List;

public class Sales {
	
	private long saleId;
	private List<Item> item;
	private String salesmanName;

	public Sales(long saleId, List<Item> item, String salesmanName) {
		this.saleId = saleId;
		this.item = item;
		this.salesmanName = salesmanName;
	}
	
	public Sales() {}

	public long getSaleId() {
		return saleId;
	}

	public List<Item> getItem() {
		return item;
	}

	public String getSalesmanName() {
		return salesmanName;
	}
}
