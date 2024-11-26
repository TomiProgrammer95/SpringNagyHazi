package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BuyDTO;
import com.example.demo.model.Purchase;
import com.example.demo.model.Ticket;
import com.example.demo.model.Users;
import com.example.demo.service.PurchasesService;

@RestController
public class PurchasesController {
	
	@Autowired
    private PurchasesService purchasesService;
	
	
	@GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return purchasesService.getAllTickets();
    }
	
	@PostMapping("/buy")
	public ResponseEntity<?> buyTicket(@RequestBody BuyDTO buyDTO) {
	    return purchasesService.buyTicket(buyDTO);
	}

}
