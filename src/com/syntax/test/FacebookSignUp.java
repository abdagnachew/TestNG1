package com.syntax.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.syntax.utils.CommonMethods;

public class FacebookSignUp extends CommonMethods{
	
	@Test 
/*
 * Using functions ONLY sign up to Facebook account
 * 
 */
		public static void main(String[] args) throws InterruptedException {
		
		//open browser and navigate to url
		setUp();
		
		//select month
		WebElement monthDD=driver.findElement(By.id("month"));
		selectDdValue(monthDD, 8);
		
		//select day
		WebElement dayDD=driver.findElement(By.id("day"));
		selectDdValue(dayDD, "5");
		
		//select year
		
		WebElement yearDD=driver.findElement(By.id("year"));
		selectDdValuebyValue(yearDD, "1992");
		
		
		
		Thread.sleep(3000);

		//tearDown();
	}

}