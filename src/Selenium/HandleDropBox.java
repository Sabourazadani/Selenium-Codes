package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) {
		// Drop down values, we have to create the object of select class
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("http://tek-school.com/bank/home/mortgage-loan/what-is-your-goal/buy-new-home-application/");

		Select select = new Select(driver.findElement(By.id("maritalstatus")));
		select.selectByVisibleText("Separated");

	}

}
