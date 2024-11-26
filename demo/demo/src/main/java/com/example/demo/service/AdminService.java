package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.PurchasesRepository;
import com.example.demo.repository.TicketRepository;

@Service
public class AdminService {

    @Autowired
    private TicketRepository ticketRepository;
    
    @Autowired
    private PurchasesRepository purchasesRepository;

    // Új jegy hozzáadása
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Jegy frissítése ID alapján
    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Optional<Ticket> ticketOpt = ticketRepository.findById(id);
        if (ticketOpt.isPresent()) {
            Ticket ticket = ticketOpt.get();
            ticket.setConcertName(updatedTicket.getConcertName());
            ticket.setCategory(updatedTicket.getCategory());
            ticket.setSeatsAvailable(updatedTicket.getSeatsAvailable());
            ticket.setPrice(updatedTicket.getPrice());
            ticket.setConcertDateTime(updatedTicket.getConcertDateTime());
            return ticketRepository.save(ticket);
        } else {
            throw new RuntimeException("Jegy nem található ezzel az ID-val: " + id);
        }
    }

    // Jegy törlése ID alapján
    public void deleteTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
        } else {
            throw new RuntimeException("Jegy nem található ezzel az ID-val: " + id);
        }
    }
    
    //Jegy lekérdezése ID alapján
    public Ticket getTicketById(Long id) {
    	 Optional<Ticket> ticket = ticketRepository.findById(id);
    	 if(ticket.isPresent()) {
    		 return ticket.get();
    	 }else {
    		 throw new RuntimeException("Jegy nem található ezzel az ID-val: " + id);
    	 }
    	
    }


}