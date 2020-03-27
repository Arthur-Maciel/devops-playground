package com.arthurmaciel.cloudnative.tema6.operation;

public class Division implements Operation{

	@Override
	public double execute(double firstNumber, double secondNumber) {
		if((boolean) (secondNumber != 0)) {		
			return firstNumber / secondNumber;
		}
		throw new ArithmeticException("You cannot do a division by zero");
	}

}
