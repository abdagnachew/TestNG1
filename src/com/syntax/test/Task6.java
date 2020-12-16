package com.syntax.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Task6 {
	/*
	 * Open chrome browser Go to “https://www.aa.com/homePage.do” Enter From and To
	 * Select departure as July 14 of 2020 Select arrival as November 8 of 2020
	 * Close browser Depart Month Year Xpath:
	 * "//div[contains(@class, 'ui-corner-left')]/div" Depart Month Days Xpath:
	 * //div[contains(@class,' ui-corner-left')]/div
	 * //div[contains(@class,
	 * 'ui-corner-left')]/following-sibling::table/tbody/tr/td Next Button Xpath:
	 * //a[@title='Next'] Return Month Xpath: //span[@class='ui-datepicker-month']
	 * Return Days Xpath: //table[@class='ui-datepicker-calendar']/tbody/tr/td You
	 * can put the logic the way you want.
	 */
	public static void main(String[] args) throws InterruptedException {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aa.com/homePage.do");
		//driver.manage().window().fullscreen();

		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("IAD", Keys.TAB);
		driver.findElement(By.xpath("//input[contains(@id,'Form.destinationAirport')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'Form.destinationAirport')]")).sendKeys("JFK");

		// now click on the calendar and select month and year
		driver.findElement(By.xpath("//input[@id='aa-leavingOn']")).click();

		boolean flag = false;
//select depart date 
		while (!flag) {
			String dMonth = driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div")).getText();
			if (dMonth.equals("July 2020")) {
				List<WebElement> depCells = driver.findElements(
						By.xpath("//div[contains(@class,'ui-corner-left')]/following-sibling::table/tbody/tr/td"));
				for (WebElement cell : depCells) {
					String cellText = cell.getText();
					if (cellText.equals("14")) {
						cell.click();
						flag = true;
						break;

					} else {
						driver.findElement(By.xpath("//a[@title='Next']")).click();
					}
					Thread.sleep(1000);
				}
				driver.findElement(By.xpath("//input[@id='aa-returningFrom']"));
				flag = false;
				// select return date
				while (!flag) {

					String rMonth = driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div"))
							.getText();
					if (rMonth.equals("November 2020")) {
						List<WebElement> returnCells = driver.findElements(By.xpath("//div[contains(@class,'ui-corner-left')]/following-sibling::table/tbody/tr/td"));

						for (WebElement rc : returnCells) {
							String returnText = rc.getText();
							if (returnText.equals("8"))
								;
							rc.click();
							flag = true;
							break;

						}
					} else {
						// if element text not equal, click next button
						driver.findElement(By.xpath("//a[@title='Next']")).click();
					}
					Thread.sleep(1000);
				}

				Thread.sleep(5000);
				driver.quit();
			}
		}
	}
}