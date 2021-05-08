package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethods {
	
	public void clickMethod(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
		
	System.out.println("Click Method called with locator: "+ locator);
	}

	public void enter_text(WebDriver driver, String locator, String inutData) {
		//driver.findElement(By.xpath(locator)).sendKeys(inutData);
		System.out.println("Inout Method called with locaor: "+locator + "and input: "+inutData);
	}
}
