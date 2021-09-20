package com.algomessiahs.reactive.reactive;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Order implements Serializable {

	int id;
	@Override
	public String toString() {
		return "Order has been placed by client id " + client_id + " for instrument id" + instrument_id + ", at price " + price
				+ " and quantity=" + quantity + " at time=" + time + ", of type" + type + "]";
	}
	String client_id;
	String instrument_id;
	double price;
    int quantity;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	LocalDateTime time;
	String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Order(int id, String client_id, String instrument_id, double price, int quantity, LocalDateTime time,
                 String type) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.instrument_id = instrument_id;
		this.price = price;
		this.quantity = quantity;
		this.time = time;
		this.type = type;
	}
	
	
}
