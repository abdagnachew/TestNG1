package com.selenium.study1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
	
	public static String url="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main (String [] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		
		
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();
		boolean errorMessage= driver.findElement(By.id("spanMessage")).isDisplayed();
		if (errorMessage) {
			System.out.println("Good");
		}else {
			System.out.println("No Good");
		}
		
		try{
			Thread.sleep(3000);
		}catch (InterruptedException ie) {
			System.out.println();
		}
		
		
		
		
		driver.quit();

	
		
		
		
		
		
		
	}
}
