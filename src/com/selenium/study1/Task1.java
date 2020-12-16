package com.selenium.study1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	
	
	public static void main (String [] args) throws InterruptedException {
	   String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

		System.setProperty("webdriver.chrome.driver", "drivers/Chromedriver.exe");
		
	WebDriver driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	
	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
	driver.findElement(By.className("button")).click();
	
	Thread.sleep(3000);

	

		boolean logoDisplay = driver.findElement(By.xpath("//div[@id='branding']//a//img")).isDisplayed();
		if (logoDisplay) {
			System.out.println("Logo is displayed");
		}else {
			System.out.println("Log not displayed");
		}
		
		driver.quit();
	}
	}
