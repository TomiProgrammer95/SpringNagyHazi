package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concertName;
    private String category; // A, B, vagy C kategóriához
    private int seatsAvailable; // Ülőhelyek száma
    private int price; // Jegy ára
    private LocalDateTime concertDateTime;
    
    

    public Ticket() {
    }

    public Ticket(String concertName, String category, int seatsAvailable, int price, LocalDateTime concertDateTime) {
        this.concertName = concertName;
        this.category = category;
        this.seatsAvailable = seatsAvailable;
        this.price = price;
        this.concertDateTime = concertDateTime;
    }

    public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public LocalDateTime getConcertDateTime() {
		return concertDateTime;
	}

	public void setConcertDateTime(LocalDateTime concertDateTime) {
		this.concertDateTime = concertDateTime;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
