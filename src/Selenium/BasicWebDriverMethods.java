package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWebDriverMethods {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		String HomePageURL = "https://www.facebook.com/";
		driver.get(HomePageURL);
		driver.manage().window().maximize();
		driver.manage().window().getSize();

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		String title = driver.getTitle();
		System.out.println(title);

		//String pageSource = driver.getPageSource();
		//System.out.println(pageSource);

		driver.navigate().to("https://www.tekschool.us/");

		driver.close();

	}

}
