package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	Ticket findByConcertNameAndCategory(String concertName, String category);

}
