package com.arthurmaciel.cloudnative.tema6.calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arthurmaciel.cloudnative.tema6.operation.Operation;

public class Calculator {

	private Map<String, Operation> availableOperations;
	private List<String> logHistory;

	public Calculator(Map<String, Operation> availableOperations) {
		logHistory = new LinkedList<String>();
		this.availableOperations = availableOperations;
	}
	
	public double calculate(double firstNumber, String operation, double secondNumber) {
		if(availableOperations.containsKey(operation)) {
			logHistory.add("Valid operation: " + firstNumber + getSymbol(operation) + secondNumber + " = " + availableOperations.get(operation).execute(firstNumber, secondNumber));
			try {
				return availableOperations.get(operation).execute(firstNumber, secondNumber);
			}catch (ArithmeticException e) {
				logHistory.add("Fail to operate : " + firstNumber + getSymbol(operation) + secondNumber);
				throw e;
			}
		} else {
			logHistory.add("Fail to operate : " + firstNumber + getSymbol(operation) + secondNumber);
			throw new ArithmeticException("Invalid operation");
		}
	}
	
	private String getSymbol(String operation) {
		switch(operation) {
		case "sum":
			return "+";
		case "sub":
			return "-";
		case "mult":
			return "*";
		case "div":
			return "/";
		case "pow":
			return "^";
			default:
				throw new IllegalArgumentException("This operation does not exist");
		}
	}
	
	public List<String> getLog(){
		return logHistory;
	}
}
