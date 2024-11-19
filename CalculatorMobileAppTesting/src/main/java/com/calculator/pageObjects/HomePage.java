package com.calculator.pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {
	
	private By oneButton= By.id("com.google.android.calculator:id/digit_1");
	private By twoButton= By.id("com.google.android.calculator:id/digit_2");
	private By threeButton= By.id("com.google.android.calculator:id/digit_3");
	private By fourButton= By.id("com.google.android.calculator:id/digit_4");
	private By fiveButton= By.id("com.google.android.calculator:id/digit_5");
	private By sixButton= By.id("com.google.android.calculator:id/digit_6");
	private By sevenButton= By.id("com.google.android.calculator:id/digit_7");
	private By eightButton= By.id("com.google.android.calculator:id/digit_8");
	private By nineButton= By.id("com.google.android.calculator:id/digit_9");
	private By zeroButton= By.id("com.google.android.calculator:id/digit_0");
	private By minusButton= By.id("com.google.android.calculator:id/op_sub");
	private By crossButton= By.id("com.google.android.calculator:id/op_mul");
	private By dividedByButton= By.id("com.google.android.calculator:id/op_div");
	private By plusButton= By.id("com.google.android.calculator:id/op_add");
	private By equalsButton= By.id("com.google.android.calculator:id/eq");
	private By resultTextView= By.id("com.google.android.calculator:id/result_final");

	
	public HomePage(AppiumDriver driver) {
		super(driver);
	}
	
	
	public void clickOneButton() {
		driver.findElement(oneButton).click();
	}
	
	public void clickTwoButton() {
		driver.findElement(twoButton).click();
	}
	
	public void clickThreeButton() {
		driver.findElement(threeButton).click();
	}
	
	public void clickFourButton() {
		driver.findElement(fourButton).click();
	}
	
	public void clickFiveButton() {
		driver.findElement(fiveButton).click();
	}
	
	public void clickSixButton() {
		driver.findElement(sixButton).click();
	}
	
	public void clickSevenButton() {
		driver.findElement(sevenButton).click();
	}
	
	public void clickEightButton() {
		driver.findElement(eightButton).click();
	}
	
	public void clickNineButton() {
		driver.findElement(nineButton).click();
	}
	
	public void clickZeroButton() {
		driver.findElement(zeroButton).click();
	}
	
	public void clickMinusButton() {
		driver.findElement(minusButton).click();
	}
	
	public void clickCrossButton() {
		driver.findElement(crossButton).click();
	}
	
	public void clickDividedByButton() {
		driver.findElement(dividedByButton).click();
	}
	
	public void clickPlusButton() {
		driver.findElement(plusButton).click();
	}
	
	
	public void clickEqualsButton() {
		driver.findElement(equalsButton).click();
	}
	
	
	public void clickNumbersButton(String digit) {
		By numberButton=By.id("com.google.android.calculator:id/digit_"+digit);
		
		driver.findElement(numberButton).click();
	}
	
	public void clickOperatorButton(String operator) {
		By operatorButton=By.id("com.google.android.calculator:id/op_"+operator);
		
		driver.findElement(operatorButton).click();
	}
	
	public int getActualResult() {
		int result= Integer.parseInt(driver.findElement(resultTextView).getText());
		
		return result;

	}
	

}
