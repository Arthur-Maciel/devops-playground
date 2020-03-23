package com.arthurmaciel.cloudnative.tema6.calculator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.arthurmaciel.cloudnative.tema6.operation.Division;
import com.arthurmaciel.cloudnative.tema6.operation.Multiply;
import com.arthurmaciel.cloudnative.tema6.operation.Operation;
import com.arthurmaciel.cloudnative.tema6.operation.Pow;
import com.arthurmaciel.cloudnative.tema6.operation.Subtraction;
import com.arthurmaciel.cloudnative.tema6.operation.Sum;

@Configuration
@ComponentScan("com.arthurmaciel.cloudnative.tema3.operation")
public class CalculatorConfig {

	@Bean
	public Calculator calculator() {
		return new Calculator(operations());
	}
	
	@Bean
	public Operation multiply() {
		return new Multiply();
	}
	
	@Bean
	public Operation division() {
		return new Division();
	}
	
	@Bean
	public Operation pow() {
		return new Pow();
	}
	
	@Bean
	public Operation subtraction() {
		return new Subtraction();
	}
	
	@Bean
	public Operation sum() {
		return new Sum();
	}
	
	@Bean
	public Map<String, Operation> operations(){
		Map<String,Operation> availableOperations = new HashMap<>();
		availableOperations.put("sum", sum());
		availableOperations.put("sub", subtraction());
		availableOperations.put("mult", multiply());
		availableOperations.put("div", division());
		availableOperations.put("pow", pow());
		
		return availableOperations;
	}
}
