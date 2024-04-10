package com.example.StoreFacePrintBynamoDb.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.StoreFacePrintBynamoDb.Dao.UserDTO;
import com.example.StoreFacePrintBynamoDb.entity.UserEntity;
import com.example.StoreFacePrintBynamoDb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final DynamoDBMapper dynamoDBMapper;

	private final String accessKey;
	private final String secretKey;

	@Autowired
	public UserServiceImpl(@Value("${cloud.aws.credentials.access-key}") String accessKey,
			@Value("${cloud.aws.credentials.secret-key}") String secretKey) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		System.out.println(accessKey + "accessKey");
		System.out.println(secretKey + "secretKey");
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.US_EAST_2) // Specify
																													// the
																													// region
																													// explicitly
				.build();
		this.dynamoDBMapper = new DynamoDBMapper(dynamoDBClient);
	}

	@Override
	public void registerUser(String fullName, String whatsappNumber, MultipartFile facePrintData) throws IOException {
		UserEntity userEntity = new UserEntity();
		userEntity.setFullName(fullName);
		userEntity.setWhatsappNumber(whatsappNumber);
		userEntity.setFacePrintData(facePrintData.getBytes());
		System.out.println("register method is invoked");
		dynamoDBMapper.save(userEntity);
	}
}
