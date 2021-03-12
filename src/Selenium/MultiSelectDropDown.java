package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();

		WebElement dropDownMultiSelect = driver.findElement(By.id("multi-select"));
		Select select = new Select(dropDownMultiSelect);
		
		select.selectByValue("California");
		Thread.sleep(2000);
		
		select.selectByIndex(5);
		Thread.sleep(2000);

		List<WebElement> allItems = select.getAllSelectedOptions();
		System.out.println(allItems.size());
		
		select.deselectAll();
		Thread.sleep(2000);

		select.selectByValue("California");
		Thread.sleep(2000);

		//Deselect the option at the given index.
		select.deselectByIndex(5);
		Thread.sleep(2000);

		
		select.deselectByIndex(5);
		Thread.sleep(2000);

		List<WebElement> allItem1 = select.getAllSelectedOptions();
		System.out.println(allItems.size());

		
	}

}
