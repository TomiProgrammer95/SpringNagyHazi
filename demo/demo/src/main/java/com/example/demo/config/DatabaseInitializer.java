package com.example.demo.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Admin;
import com.example.demo.model.Purchase;
import com.example.demo.model.Ticket;
import com.example.demo.model.Users;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.PurchasesRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, TicketRepository ticketRepository, PurchasesRepository purchasesRepository, AdminRepository adminRepository) {
        return args -> {
            // Dummy adatok feltöltése a Users táblába
        	Users user1 = userRepository.save(new Users("alma","123", "Tomi"));
        	Users user2 = userRepository.save(new Users("dinnye","123", "Béla"));

            // Dummy adatok feltöltése a Tickets táblába
        	Ticket ticket1 = ticketRepository.save(new Ticket("EMINEM", "A", 100, 50, LocalDateTime.of(2024, 11, 15, 19, 30)));
        	Ticket ticket2 = ticketRepository.save(new Ticket("AC/DC", "B", 50, 30, LocalDateTime.of(2024, 12, 10, 20, 0)));
        	Ticket ticket3 = ticketRepository.save(new Ticket("EMINEM", "C", 100, 60, LocalDateTime.of(2024, 11, 16, 18, 0)));
        	Ticket ticket4 = ticketRepository.save(new Ticket("Halott Pénz", "B", 100, 80, LocalDateTime.of(2024, 11, 25, 21, 0)));
        	Ticket ticket5 = ticketRepository.save(new Ticket("Azahria", "C", 100, 100, LocalDateTime.of(2024, 12, 5, 19, 30)));

            
        	// Dummy adatok feltöltése a Purchases táblába
        	purchasesRepository.save(new Purchase(
        	    user1, 
        	    ticket1.getConcertName(), 
        	    ticket1.getConcertDateTime(), 
        	    ticket1.getCategory(), 
        	    2 // vásárolt mennyiség
        	));

        	purchasesRepository.save(new Purchase(
        	    user1, 
        	    ticket4.getConcertName(), 
        	    ticket4.getConcertDateTime(), 
        	    ticket4.getCategory(), 
        	    4 // vásárolt mennyiség
        	));

        	purchasesRepository.save(new Purchase(
        	    user2, 
        	    ticket2.getConcertName(), 
        	    ticket2.getConcertDateTime(), 
        	    ticket2.getCategory(), 
        	    1 // vásárolt mennyiség
        	));
            
            adminRepository.save(new Admin("admin", "admin"));
        };
    }
}