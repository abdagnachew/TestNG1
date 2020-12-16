package com.selenium.study1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {

	public static String url = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(2000);

		driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/basic-radiobutton-demo.html");

		WebElement btn = driver.findElement(By.cssSelector("input[name='optradio']"));
		btn.click();
		Thread.sleep(2000);

		WebElement clickCheck = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
		clickCheck.click();
		
		//String returnText = driver.findElement(By.xpath("//p[class='radiobutton']")).getAttribute("value");
		//System.out.println(returnText);
		
		WebElement maleBtn = driver.findElement(By.xpath("//input[@name='gender']"));
		maleBtn.click();

		WebElement groupBtn = driver.findElement(By.xpath("//input[@value='15 - 50']"));
		groupBtn.click();
		Thread.sleep(3000);
		
		if (maleBtn.isSelected() && groupBtn.isSelected()) {
			System.out.println("Passed Test");
		}else {
			System.out.println("Failed Test");
		}

		driver.quit(); 

	}

}
