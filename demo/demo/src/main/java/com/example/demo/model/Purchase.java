package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private String concertName;       // Koncert neve
    private LocalDateTime concertDateTime; // Koncert időpontja
    private String category;          // Kategória
    private int quantity;             // Hány jegyet vett a felhasználó

    public Purchase() {}

    public Purchase(Users user, String concertName, LocalDateTime concertDateTime, String category, int quantity) {
        this.user = user;
        this.concertName = concertName;
        this.concertDateTime = concertDateTime;
        this.category = category;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public LocalDateTime getConcertDateTime() {
        return concertDateTime;
    }

    public void setConcertDateTime(LocalDateTime concertDateTime) {
        this.concertDateTime = concertDateTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
