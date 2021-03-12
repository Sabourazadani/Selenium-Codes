package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://tekschool.us");
		
		driver.findElement(By.cssSelector("li#menue-item-331>a"));
		
		driver.findElement(By.cssSelector("ul.feautures-list>li>span"));
		
		
		
		
		

	}

}
