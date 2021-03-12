package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://tekschool.us/");

		// 1. Xpath locatr --> There are two ways & customs xpath
		// --> Absolute Xpath = should not be used
		// --> relative Xpath = should be used
		// driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Azadani");

		// 2. id locater -->
		//driver.findElement(By.id("firstname")).sendKeys("Sabour");

		// 3. name locater -->
		//driver.findElement(By.name("Number")).sendKeys("123-456-789");

		// 4. linkText
		driver.findElement(By.linkText("About")).click();

		// 5. partialLinkText

		// 6. CSSSelector --> For creating CSS Selector, there are two ways
		// --> if id is available, use ("# id equal to whatever is there")
		// --> if class is available, use (". class equal to whatever is there")
		// driver.findElement(By.cssSelector("#address")).sendKeys("123 Sky Driver");

		// 7. className locater
		
		// 8. tageName

	}

}
