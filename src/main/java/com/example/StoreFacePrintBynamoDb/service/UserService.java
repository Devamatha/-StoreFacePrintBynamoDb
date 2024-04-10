package com.example.StoreFacePrintBynamoDb.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public interface UserService {
	public void registerUser(String fullName,String whatsappNumber,MultipartFile facePrintData)throws IOException;
}
