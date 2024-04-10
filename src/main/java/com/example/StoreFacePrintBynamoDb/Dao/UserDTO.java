package com.example.StoreFacePrintBynamoDb.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String fullName;
	private String whatsappNumber;
	private byte[] facePrintData;

}
