package com.anil.awslambda.model;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@DynamoDBTable(tableName = "employees")
@Data
public class Employee {

	@DynamoDBHashKey(attributeName = "empId")
	private String empId;
	@DynamoDBAttribute(attributeName = "name")
	private String name;
	@DynamoDBAttribute(attributeName = "email")
	private String email;
	@DynamoDBAttribute(attributeName = "gender")
	private String gender;
	@DynamoDBAttribute(attributeName = "date")
	private Date date;
	@DynamoDBAttribute(attributeName = "status")
	private boolean status;
	@DynamoDBAttribute(attributeName = "countryName")
	private String countryName;
	@DynamoDBAttribute(attributeName = "stateName")
	private String stateName;
	@DynamoDBAttribute(attributeName = "cityName")
	private String cityName;
}
