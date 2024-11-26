package com.example.demo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Admin;
import com.example.demo.model.Users;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByUsernameAndPassword(String username, String password);
	

}
