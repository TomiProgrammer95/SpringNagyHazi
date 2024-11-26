package com.example.demo.dto;

import java.time.LocalDateTime;

public class BuyDTO {

	
	private String email;
	private String username;
	private String password;
	private String concertName;
	private String category; // A, B, vagy C kategóriához
	private int seatsAvailable; // Ülőhelyek száma
	private int price; // Jegy ára
	private LocalDateTime concertDateTime;
	
	private int quantity;
	 
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConcertName() {
		return concertName;
	}
	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDateTime getConcertDateTime() {
		return concertDateTime;
	}
	public void setConcertDateTime(LocalDateTime concertDateTime) {
		this.concertDateTime = concertDateTime;
	}
	 
	 
}
