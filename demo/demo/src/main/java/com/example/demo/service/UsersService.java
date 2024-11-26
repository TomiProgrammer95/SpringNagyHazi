package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PurchasedTicketDTO;
import com.example.demo.model.Purchase;
import com.example.demo.model.Ticket;
import com.example.demo.model.Users;
import com.example.demo.repository.PurchasesRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;



@Service
public class UsersService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private PurchasesRepository purchasesRepository;
	
	public boolean registerUser(Users user) {
        // Ellenőrizzük, hogy már létezik-e a felhasználó
        Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return false; // A felhasználó már létezik
        }
        
        // Új felhasználó mentése
        userRepository.save(user);
        return true;
    }
	
	
	public List<PurchasedTicketDTO> getAllPurchasedTickets(Long userId){
		 Optional<Users> user = userRepository.findById(userId);
		 if(user.isPresent()) {
			 List<Purchase> purchases = purchasesRepository.findByUser(user);
			 return purchases.stream()
				        .map(purchase -> new PurchasedTicketDTO(
				            purchase.getCategory(),
				            purchase.getConcertDateTime(),
				            purchase.getConcertName(),
				            purchase.getQuantity()
				        ))
				        .toList();
		 	}else {
		 		throw new RuntimeException("Felhasználó nem található ezzel az ID-val: " + userId);
		 	}
		 }
		

}
