package com.example.demo.service;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BuyDTO;
import com.example.demo.model.Purchase;
import com.example.demo.model.Ticket;
import com.example.demo.model.Users;
import com.example.demo.repository.PurchasesRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;

@Service
public class PurchasesService {
	
	 @Autowired
	 private PurchasesRepository purchasesRepository;
	 
	 @Autowired
	 private TicketRepository ticketRepository;
	 
	 @Autowired
	 private UserRepository userRepository;

	  
	    
	 // Összes jegy lekérdezése
	    public List<Ticket> getAllTickets() {
	        return ticketRepository.findAll();
	    }
	    
	
	    public ResponseEntity<?> buyTicket(BuyDTO buyDTO) {
	        // 1. Felhasználó keresése
	        Optional<Users> userOptional = userRepository.findByEmailAndPassword(buyDTO.getEmail(), buyDTO.getPassword());
	        if (userOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(Map.of("message", "Felhasználó nem található vagy hibás belépési adatok."));
	        }

	        Users user = userOptional.get();

	        // 2. Jegy ellenőrzése
	        Ticket ticket = ticketRepository.findByConcertNameAndCategory(buyDTO.getConcertName(), buyDTO.getCategory());
	        if (ticket == null || ticket.getSeatsAvailable() < buyDTO.getQuantity()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(Map.of("message", "Nincs elérhető jegy a megadott kategóriában."));
	        }

	        // 3. Jegyek frissítése
	        ticket.setSeatsAvailable(ticket.getSeatsAvailable() - buyDTO.getQuantity());
	        ticketRepository.save(ticket);

	        // 4. Vásárlás létrehozása
	        Purchase purchase = new Purchase(user, ticket.getConcertName(), ticket.getConcertDateTime(), ticket.getCategory(), buyDTO.getQuantity());
	        purchasesRepository.save(purchase);

	        // 5. Sikeres válasz
	        return ResponseEntity.ok(Map.of("message", "Jegyvásárlás sikeres!"));
	    }
	    
	    

}
