package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDTO;
import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.service.AdminService;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
    public Users userLogin(@RequestBody LoginDTO loginDto) {
		return loginService.userLogin(loginDto.getEmail(), loginDto.getPassword());
    }
	
	@PostMapping("/adminlogin")
    public Admin adminLogin(@RequestBody Admin admin) {
		return loginService.adminLogin(admin.getUsername(), admin.getPassword());
    }

}
