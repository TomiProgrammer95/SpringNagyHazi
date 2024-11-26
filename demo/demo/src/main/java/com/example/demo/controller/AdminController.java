package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ticket;
import com.example.demo.service.AdminService;
import com.example.demo.service.PurchasesService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    // Új jegy hozzáadása
    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return adminService.addTicket(ticket);
    }
    
    // Jegy lekérdezése ID alapján
    @GetMapping("/ticket/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return adminService.getTicketById(id);
    }

    // Jegy frissítése ID alapján
    @PutMapping("/edit/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return adminService.updateTicket(id, ticket);
    }

    // Jegy törlése ID alapján
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteTicket(@PathVariable Long id) {
    	Map<String, String> response = new HashMap<>();
        try {
            adminService.deleteTicket(id);
            response.put("message", "Sikeres Törlés!");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
        	response.put("message", "Törlés Sikertelen!");
        	return ResponseEntity.badRequest().body(response);
        }
    }

    
}
