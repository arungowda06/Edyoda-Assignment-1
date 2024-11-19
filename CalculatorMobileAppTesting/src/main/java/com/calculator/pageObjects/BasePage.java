package com.calculator.pageObjects;

import io.appium.java_client.AppiumDriver;

public class BasePage {
	protected AppiumDriver driver;
	
	public BasePage(AppiumDriver driver) {
		this.driver=driver;
	}

}
