package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Users userLogin(String email, String password) {
		Optional<Users> user = userRepository.findByEmailAndPassword(email, password);
	    return user.orElseThrow(() -> new RuntimeException("Felhasználó nem található."));
	}
	
	public Admin adminLogin(String username, String password) {
		Optional<Admin> user = adminRepository.findByUsernameAndPassword(username, password);
	    return user.orElseThrow(() -> new RuntimeException("Felhasználó nem található."));
	}

}
