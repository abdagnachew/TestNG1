package com.selenium.study1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tablesTRTD {
	public static String url = "http://166.62.36.207/syntaxpractice/";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Table']")).click();
		driver.findElement(By.xpath("(//a[text()='Table Data Search'])[2]")).click();

		System.out.println("-------row data-------");

		List<WebElement> row = driver.findElements(By.xpath("//table[@id='task-table']//tr"));
		System.out.println("# of Webtables row visible:" + row.size());

		Iterator<WebElement> it = row.iterator();
		while (it.hasNext()) {
			String rowText = it.next().getText();
			System.out.println(rowText);
			System.out.println("--------------");

		}
		System.out.println("--------col data------");

		List<WebElement> col = driver.findElements(By.xpath("//table[@id='task-table']//td"));
		System.out.println("# of WebTable columns visible:" + col.size());

		for (WebElement columns : col) {
			String columnText = columns.getText();
			System.out.println(columnText);

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
System.out.println(e);			
e.printStackTrace();
		}

		driver.close();

	}

}
