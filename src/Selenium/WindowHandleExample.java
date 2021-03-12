package Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandleExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://tekschool.us/");

		// creating instance of the webdriver wait
		WebDriverWait wait = new WebDriverWait(driver, 5);

		// creating instance of the action class
		Actions a = new Actions(driver);

		// finding the webelemnts
		WebElement aboutBtn = driver.findElement(By.xpath("//*[@title='About']"));
		WebElement contactBtn = driver.findElement(By.xpath("//*[@title='Contact']"));

		// waiting for the 'about' button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(aboutBtn));

		// holding control key down, then clicking on the about button on the page to
		// open it in a new tab
		a.keyDown(Keys.CONTROL).click(aboutBtn).build().perform();

		// waiting for the 'contact' button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(contactBtn));

		// holding control key down, then clicking on the about button on the page to
		// open it in a new tab
		a.keyDown(Keys.CONTROL).click(contactBtn).build().perform();

		// getwindowhandle will return the key for the current window
		String mainWindow = driver.getWindowHandle();
		System.out.println(driver.getTitle() + "  >>>>>  " + mainWindow);

		// getWindowHandles will return the keys to all of the open tabs in that session
		// this method will return a set of String
		Set<String> allWindowKeys = driver.getWindowHandles();

		String title = "";

		Thread.sleep(3000);

		for (String key : allWindowKeys) {
			if (!key.equals(mainWindow)) {
				driver.switchTo().window(key);
				title = driver.getTitle();
				System.out.println(title + "  >>>>>  " + key);
				Thread.sleep(3000);
			}
		}

		driver.switchTo().window(mainWindow);

	}

}
