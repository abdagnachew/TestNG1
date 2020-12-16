package com.syntax.Study2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemo{
	
	public static void main(String[] args) {
		System.setProperty("driver.CHROME_DRIVER_LOG_PROERTY", "true");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.cssSelector("div#checkbox")).click();
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
		
		
//		String text=driver.findElement(By.id("message")).getText();
//		System.out.println(text);
		
		driver.close();
		
		
		
	}
	
}