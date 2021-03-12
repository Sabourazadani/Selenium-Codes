package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsMethods {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		String HomePageURL = "https://www.facebook.com/";
		driver.get(HomePageURL);
		driver.manage().window().maximize();

		driver.findElement(By.name("email")).sendKeys("Kyokushin Karate");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("email")).clear();

		// The get elements are very important to get the value or attribute elements
		System.out.println(driver.findElement(By.name("email")).getAttribute("class"));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).getCssValue("text-decoration"));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).getSize());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).getLocation());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).getTagName());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).isSelected());

	}

}
