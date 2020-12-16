package com.selenium.study1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
	public static void main (String [] args) {
	
	System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver.exe");
	String url = "http://newtours.demoaut.com/";
	
	WebDriver driver = new ChromeDriver();
	
	driver.get(url);
	
	driver.get("http://newtours.demoaut.com/mercuryregister.php");
	
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Abe");
	driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Dag");
	driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("7039283832");
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("dagnachew@gmail.com");
	
		driver.findElement(By.xpath("//input[@name='register']"))	;
		
		driver.quit();

	
	
	
	
	
	
	

}
}
