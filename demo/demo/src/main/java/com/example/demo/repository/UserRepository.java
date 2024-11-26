package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByEmailAndPassword(String email, String password);
	Optional<Users> findByEmail(String email);
	

}
