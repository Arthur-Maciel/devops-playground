package com.arthurmaciel.cloudnative.tema6.operation;

public class Pow implements Operation{

	@Override
	public double execute(double firstNumber, double secondNumber) {
		return Math.pow(firstNumber, secondNumber);
	}

}
