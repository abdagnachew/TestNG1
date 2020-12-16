package com.syntax.test;

import org.openqa.selenium.By;

import com.syntax.pages.LoginPage;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class verifyLogo extends CommonMethods {

	
	public static void main(String[] args) throws InterruptedException {
		setUp(); //hrms
		
		LoginPage login=new LoginPage();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		Thread.sleep(2000);
		
		boolean verifyLogo=driver.findElement(By.xpath("//div[@id='divLogo']")).isDisplayed();
		if (verifyLogo) {
			System.out.println("Passed");
			
		}else {
			System.out.println("Failed");
		}
		Thread.sleep(3000);
		
		
		
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Abe");
				
		tearDown();
		
		
		
		
	}
}


	
	


