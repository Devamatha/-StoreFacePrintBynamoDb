package com.example.StoreFacePrintBynamoDb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
public class DynamoDBConfig {
	 @Bean
	    public AmazonDynamoDB amazonDynamoDB() {
		 System.err.println("config file is invoked");
	        return AmazonDynamoDBClientBuilder.standard()
	                .withRegion(Regions.US_EAST_2) // Specify the desired region here
	                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
	                .build();
	    }

	 
}
