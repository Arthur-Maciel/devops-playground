package com.arthurmaciel.cloudnative.tema6.operation;

public class Subtraction implements Operation{

	@Override
	public double execute(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}

}
