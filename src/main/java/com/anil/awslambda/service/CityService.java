package com.anil.awslambda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.anil.awslambda.model.City;

@Service
public class CityService {

	@Autowired
	DynamoDBMapper dynamoDBMapper;
	
	public City saveCity(City city) {
		dynamoDBMapper.save(city);
		return city;
	}

	
//	public City stateAgainstCity(String stateId) {
////		System.out.println(city);
//		System.out.println("State Id " + stateId);
//		City city= dynamoDBMapper.load(City.class, stateId);
//		System.out.println("City {} "+city.getCityId());
//		return city;  
//		
//	}
	
	
	public List<City> getByStateId(String stateId) {  
		System.out.println("State Id " + stateId);
	    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	    scanExpression.addFilterCondition("stateId", new Condition()                                           
	       .withComparisonOperator(ComparisonOperator.EQ)                                                
	       .withAttributeValueList(new AttributeValue().withS(stateId)));
	    return dynamoDBMapper.scan(City.class, scanExpression);
	}
	
	
	
}
