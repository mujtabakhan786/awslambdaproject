package com.anil.awslambda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.anil.awslambda.model.State;

@Service
public class StateService {

	@Autowired
	DynamoDBMapper dynamoDBMapper;

	public State saveSate(State state) {
		dynamoDBMapper.save(state);

		return state;
	}

	public List<State> getState() {
		return dynamoDBMapper.scan(State.class, new DynamoDBScanExpression());
	}
	

}
