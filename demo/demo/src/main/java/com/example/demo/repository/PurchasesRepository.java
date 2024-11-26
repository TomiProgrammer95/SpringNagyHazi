package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Purchase;
import com.example.demo.model.Users;

public interface PurchasesRepository extends JpaRepository<Purchase, Long> {
	List<Purchase> findByUser(Optional<Users> user);

	
	

}
