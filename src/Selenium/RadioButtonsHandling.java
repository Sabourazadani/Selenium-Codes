package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.singaporeair.com/en_UK/us/home#/book/bookflight");

		WebElement radio1 = driver.findElement(By.id("redeemFlights"));
		radio1.click();
		System.out.println(radio1.isSelected());
		System.out.println(driver.findElements(By.name("book-flight-radio")).size());
		
	}

}
