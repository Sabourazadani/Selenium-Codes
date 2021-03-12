package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxVsRadioButtons {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://tekschool.us/contact/");
		driver.manage().window().maximize();
		
		WebElement CheckBox = driver.findElement(By.xpath("//input[@type='checkbox' and @name= 'acceptance-737']"));
		
		System.out.println(CheckBox.isDisplayed());
		System.out.println(CheckBox.isEnabled());
		System.out.println(CheckBox.isSelected());
		
		
		
		if (!CheckBox.isSelected()){
			CheckBox.click();
			System.out.println("Check Box is selected");
			
		} else {
			System.out.println("It is already selected");
		}
		if (!CheckBox.isSelected()){
			CheckBox.click();
			
		} else {
			System.out.println("It is already selected");
		}
		

	}

}
