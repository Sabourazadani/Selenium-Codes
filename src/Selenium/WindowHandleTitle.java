package Selenium;

import java.util.HashMap;
import java.util.Map;
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

public class WindowHandleTitle {

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
		String firstWindow = driver.getWindowHandle();
		
		// getWindowHandles will return the keys to all of the open tabs in that session
		// this method will return a set of String
		Set<String> allWindowKeys = driver.getWindowHandles();

		// this map will store the title of the tabs as values and window keys and key
		// <Window Key, Window Title>
		Map<String, String> windowTitleAndKeys = new HashMap<String, String>();

		// this will loop through all of the keys
		for (String key : allWindowKeys) {
			Thread.sleep(2000);
			driver.switchTo().window(key);
			Thread.sleep(2000);
			windowTitleAndKeys.put(key, driver.getTitle());
		}

		System.out.println(windowTitleAndKeys);

		// this loop is going through all of the keys in the hashmap
		for (String key : windowTitleAndKeys.keySet()) {
			
			// this condition checks to see if the title contains that value 'about' and
			// then returns the key to that window
			if (windowTitleAndKeys.get(key).toLowerCase().contains("about")) {

				// we print and switch to that window here
				System.out.println(key);
				driver.switchTo().window(key);
			}
		}

	}
}