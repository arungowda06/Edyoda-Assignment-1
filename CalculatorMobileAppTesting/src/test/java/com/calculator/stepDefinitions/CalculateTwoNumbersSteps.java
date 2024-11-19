package com.calculator.stepDefinitions;


import static org.junit.Assert.assertEquals;
import com.calculator.pageObjects.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculateTwoNumbersSteps {
	private AppiumDriver driver;
	private HomePage homePage;
	
	public CalculateTwoNumbersSteps() {
		System.out.println("Initializing CalculateTwoNumbersSteps...");
		this.driver=Hooks.getDriver();
		if(driver == null) {
			System.out.println("Driver is null in CalculateTwoNumbersSteps constructor!");
			throw new RuntimeException("Driver is not initialized.");
		}
		
		this.homePage=new HomePage(driver);
		
		}
	
	
	int expectedResult;
	
	
	@Given("the user is on Calculator home page")
	public void userIsOnCalculatorHomePage() {
		System.out.println("Calculator Home Page Displayed.");
		
	}
	
	@When("the user select first number {string} and operator {string} and second number {string}")
	public void userSelectsNumberAndOperator(String firstNumber, String operator, String secondNumber) {
		homePage.clickNumbersButton(firstNumber);
		homePage.clickOperatorButton(operator);
		homePage.clickNumbersButton(secondNumber);
		
		
		int firstDigit=Integer.parseInt(firstNumber);
		int secondDigit=Integer.parseInt(secondNumber);
		
		if(operator.equalsIgnoreCase("add")) {
			this.expectedResult=(firstDigit+secondDigit);
		}
		else if (operator.equalsIgnoreCase("sub")) {
			this.expectedResult=(firstDigit-secondDigit);
		} 
		else if (operator.equalsIgnoreCase("mul")) {
			this.expectedResult=(firstDigit*secondDigit);
		} 
		else if (operator.equalsIgnoreCase("div")) {
			this.expectedResult=(firstDigit/secondDigit);
		}
	}
	
	@When("the user clicks on equals button")
	public void userClicksEqualsButton() {
		homePage.clickEqualsButton();
	}
	
	@Then("the user should see the calculation result")
	public void resultDisplayed() {
		System.out.println("result =" + homePage.getActualResult());

		assertEquals(homePage.getActualResult(), expectedResult); //assertion
		
	}

}
