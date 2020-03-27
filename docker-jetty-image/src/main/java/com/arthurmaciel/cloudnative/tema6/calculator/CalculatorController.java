package com.arthurmaciel.cloudnative.tema6.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet("/calculator")
public class CalculatorController extends HttpServlet{

	private static final long serialVersionUID = 1L;


	private ApplicationContext appContext;
	private Calculator calculator;

	public CalculatorController() {
		super();	
		appContext = new AnnotationConfigApplicationContext(CalculatorConfig.class);
		this.calculator = (Calculator) appContext.getBean("calculator");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {		
		
		try {
			PrintWriter writer = response.getWriter();
			if(request.getParameterMap().containsKey("log")) {			
				writer.println("Results log: " + calculator.getLog());
			} else {
				try {	
					if(request.getParameterMap().containsKey("firstNumber") && request.getParameterMap().containsKey("op") && request.getParameterMap().containsKey("secondNumber")) {
							String firstNumber = request.getParameter("firstNumber");
							String operation = request.getParameter("op");
							String secondNumber = request.getParameter("secondNumber");
							if(firstNumber.matches("-?\\d+(\\.\\d+)?") && secondNumber.matches("-?\\d+(\\.\\d+)?")) {
								writer.println("Result = " + calculator.calculate(Double.valueOf(firstNumber), operation, Double.valueOf(secondNumber)));
							} else {
								writer.print("It was insert a non number for firstNumber or secondNumber, make sure they are numbers");
							}			
					} else {
						writer.print("You must insert all the parameters (firstNumber, op and secondNumber)");
					}
				} catch (ArithmeticException e) {
					writer.print(e.getMessage());
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
