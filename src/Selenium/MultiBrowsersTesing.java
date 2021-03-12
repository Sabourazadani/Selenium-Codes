package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiBrowsersTesing {

	public static void main(String[] args) {

		String driver_to_Use = "chrome";

		WebDriver driver;

		if (driver_to_Use.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (driver_to_Use.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (driver_to_Use.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		//System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");
		WebDriver driver1 = new ChromeDriver();

		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver1.get("http://tek-school.com/retail/");
		driver1.findElement(By.linkText("Canon EOS 5D")).click();

		Select dd = new Select(driver1.findElement(By.id("input-option226")));
		dd.selectByValue("15");
		WebElement quantitTXT = driver1.findElement(By.id("input-quantity"));

		quantitTXT.clear();
		quantitTXT.sendKeys("8");

		driver1.findElement(By.id("button-cart")).click();

	}

}
