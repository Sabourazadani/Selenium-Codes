package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://canvas.instructure.com/login/canvas");
		driver.findElement(By.xpath("//*[@id=\"pseudonym_session_remember_me\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"pseudonym_session_remember_me\"]")).click();

	}

}
