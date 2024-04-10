package com.example.StoreFacePrintBynamoDb.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.StoreFacePrintBynamoDb.Dao.UserDTO;
import com.example.StoreFacePrintBynamoDb.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String registerUser(@RequestParam String fullName, @RequestParam String whatsappNumber,
			@RequestParam MultipartFile facePrintData) throws IOException {

		userService.registerUser(fullName, whatsappNumber, facePrintData);
		System.out.println("service Impl method invoking ");
		return "User registered successfully";
	}
}
