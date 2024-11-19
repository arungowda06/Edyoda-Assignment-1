package com.calculator.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	private static AppiumDriver driver;
	private Properties props;
	private FileReader reader;
	
	@Before
	public void setup() throws IOException {
		System.out.println("Setting up Appium driver.");
		
		props=new Properties();
		reader=new FileReader("src/test/resources/config/config.properties");
		props.load(reader);
		
		if(driver == null) {
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("platformName", props.getProperty("platformName"));
				caps.setCapability("deviceName", props.getProperty("deviceName"));
				caps.setCapability("appPackage", props.getProperty("appPackage"));
				caps.setCapability("appActivity", props.getProperty("appActivity"));
				
				driver=new AndroidDriver(new URL(props.getProperty("appium.server.url")), caps);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Appium driver initialized successfully.");
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to initialize Appium driver.");
			}
		}
	}
	
	@After
	public void tearDown() {
		System.out.println("Tearing down Appium driver...");
		if(driver != null) {
			driver.quit();
			driver=null;
			System.out.println("Appium driver quit successfully.");
		}
	}
	
	public static AppiumDriver getDriver() {
		System.out.println("Returning Appium driver instance...");
		return driver;
	}
	
	
}

