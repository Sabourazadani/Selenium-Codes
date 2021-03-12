package JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlretHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://tekschool.us/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// creating an alert on the page
		js.executeScript("alert('Testing is fun')");

		// waiting for 2 seconds
		Thread.sleep(2000);

		// capturing the alert and storing it in obj of alert
		Alert alert = driver.switchTo().alert();
		// accepting the alert / clicking on 'OK'
		alert.accept();

		// wait for 2 seconds
		Thread.sleep(2000);

		// we create a prompt, which has two options Yes/No
		js.executeScript("confirm('trying to work with alerts')");

		// wait for 2 seconds
		Thread.sleep(2000);

		// capturing the alert/confirm
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss(); // would click on NO or Cancel on the confirm

		// wait for 2 seconds
		Thread.sleep(2000);

		js.executeScript("prompt('trying to work with alerts')");
		// wait for 2 seconds
		Thread.sleep(2000);

		Alert alert3 = driver.switchTo().alert();
		alert3.accept();

	}
}