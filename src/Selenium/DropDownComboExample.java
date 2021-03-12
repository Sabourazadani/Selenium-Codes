package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownComboExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// creating the instance of the JS
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// creating instance of the webdriverwait
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// going to the website
		driver.get("https://www.aa.com/homePage.do");
		// finding the textbox element, clear and send keys
		WebElement originTxt = driver.findElement(By.xpath("(//*[@name='originAirport'])[1]"));
		originTxt.clear();
		originTxt.sendKeys("wash");

		// find all of the elements that was suggested after i typed 'wash'
		List<WebElement> items = driver.findElements(By.xpath("//*[@id='ui-id-1']//li//a"));

		for (WebElement item : items) {
			if (item.getText().contains("Seattle Tacoma Intl")) {
				System.out.println(item.getText());
//				js.executeScript("arguments[0].click();", item);
				item.click();
			}

		}

//		js.executeScript("alert('testing is fun')");

	}

}
