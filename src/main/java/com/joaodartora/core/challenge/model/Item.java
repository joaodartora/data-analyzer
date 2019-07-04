package com.joaodartora.core.challenge.model;

public class Item {

	private long id;
	private long quantity;
	private float price;
	
	public Item(long id, long quantity, float price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public float getPrice() {
		return price;
	}
}
