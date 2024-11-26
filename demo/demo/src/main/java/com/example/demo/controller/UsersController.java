package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PurchasedTicketDTO;
import com.example.demo.model.Ticket;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;


@RestController
public class UsersController {
	
	@Autowired
	private UsersService userService;
	

	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody Users user) {
	    boolean isRegistered = userService.registerUser(user);

	    Map<String, String> response = new HashMap<>();
	    if (isRegistered) {
	        response.put("message", "Sikeres regisztráció!");
	        return ResponseEntity.ok(response);
	    } else {
	        response.put("message", "Hiba történt a regisztráció során!");
	        return ResponseEntity.badRequest().body(response);
	    }
	}
	
	@GetMapping("/purchasedTickets/{id}")
    public List<PurchasedTicketDTO> getAllPurchasedTickets(@PathVariable Long id) {
        return userService.getAllPurchasedTickets(id);
    }
	
	
	


}
