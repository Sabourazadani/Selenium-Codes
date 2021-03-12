package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHanling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String HomePageURL = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert";
		driver.get(HomePageURL);
		
		driver.switchTo().frame(0);
		
		// driver.switchTo().frame("iframeResult");
		
		//WebElement frame1 = driver.findElement(By.id("frameElement"));
		//driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("/html/body/button")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		

	}

}
