package com.arthurmaciel.cloudnative.tema6.calculator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CalculatorConfig.class})
public class CalculatorTest {

	@Autowired
	private Calculator calculator;

	@Test
	public void testDivision() {
		assertEquals(2, calculator.calculate(4, "div", 2));
	}

	@Test
	public void testMultiply() {
		assertEquals(8, calculator.calculate(4, "mult", 2));
	}

	@Test
	public void testPow() {
		assertEquals(16, calculator.calculate(4, "pow", 2));
	}

	@Test
	public void testSum() {
		assertEquals(6, calculator.calculate(4, "sum", 2));
	}

	@Test
	public void testSubtraction() {
		assertEquals(2, calculator.calculate(4, "sub", 2));
	}

	@Test(expected = ArithmeticException.class)
	public void testArithmeticException() {
		calculator.calculate(4, "div", 0);
	}
	
	@Test
	public void testGetLog() {
		assertNotNull(calculator.getLog());
	}

}
