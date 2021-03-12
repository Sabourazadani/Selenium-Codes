package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo");
		driver.manage().window().maximize();

		WebElement dropdown = driver.findElement(By.name("employees_c"));

		Select select = new Select(dropdown);
		
		// Select all options that have a value matching the argument.
		select.selectByValue("level1");
		Thread.sleep(2000);
		
		//Select all options that display text matching the argument.
		select.selectByVisibleText("51 – 100 employees");
		Thread.sleep(2000);
		
		//Select the option at the given index.
		select.selectByIndex(5);
		Thread.sleep(2000);

	}

}
