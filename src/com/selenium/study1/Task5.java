package com.selenium.study1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task5 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");

		String singUpTitle = driver.getTitle();
		System.out.println("Main Page Title is:: " + singUpTitle);

		WebElement DD = driver.findElement(By.xpath("//div[@class='TquXA']"));
		DD.click();
		Select select = new Select(DD);
		
		List<WebElement> options=select.getOptions();
		System.out.println(options.size());
		Thread.sleep(2000);
		
		Iterator<WebElement> it=options.iterator();
		 while (it.hasNext()) {
			 select.selectByVisibleText("English(United States)");
			 Thread.sleep(2000);
			
		
			
		 driver.get("'https://support.google.com/accounts?hl=en");


		/*
		 * How to get window handle? In Selenium we have two method to get the hand of
		 * window. getWindowHandle(); getWindowHandles();
		 */

		Set<String> allWindowHandles = driver.getWindowHandles();
		// Returns set of string IDs of all windows currently opened by the current
		// instance.

		System.out.println("Number of windows opened are:: " + allWindowHandles.size());// get size of set.

		Iterator<String> it2 = allWindowHandles.iterator();

		String mainWindowHandle = it2.next();// Returns the id of Mine Window
		System.out.println("Id of Main window:: " + mainWindowHandle);

		String childWindowHandle = it2.next();// Returns the id of Child Window
		System.out.println("Id of Child window:: " + childWindowHandle);

		// Using switchTo method we switch to another window by passing the handle/ID of
		// window.
		driver.switchTo().window(childWindowHandle);
		String childWindowTitle = driver.getTitle();
		System.out.println("Child Page Title is:: " + childWindowTitle);
		driver.close();

	}

	}
}
