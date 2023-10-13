package com.anil.awslambda.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@DynamoDBTable(tableName = "city")
@Data
public class City {

	@DynamoDBAttribute(attributeName = "stateId")
	private String stateId;

	@DynamoDBHashKey(attributeName = "cityId")
	@DynamoDBAutoGeneratedKey
	private String cityId;
	@DynamoDBAttribute(attributeName = "cityName")
	private String cityName;
}

