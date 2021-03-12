package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverBasics {

	public static void main(String[] args) {
		// Inspect shortcut --- > Windows: Ctrl + Shift + J. Mac: Cmd + Opt +J.

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);

		
		// driver.get("URL") --> To navigate to an application.
		driver.get("https://tek-school.com/real-estate/");
		
		
		driver.findElement(By.id("priceMin")).sendKeys("1000");
		driver.findElement(By.id("priceMax")).sendKeys("2000");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		WebElement findBTN = driver.findElement(By.id("btnleft"));
		wait.until(ExpectedConditions.elementToBeClickable(findBTN));
		findBTN.click();
		
		System.out.println("End of the Execution");
		
		//.click();


	}

}
