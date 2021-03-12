package ExamplesAutomations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _1RetailWebsiteAddItemsToCart {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://tek-school.com/retail/");

		// Creating an object of WebElements
		WebElement eos5D = driver.findElement(By.linkText("Canon EOS 5D"));
		eos5D.click();

		// Creating an object of select to interact with the drop down page
		Select select = new Select(driver.findElement(By.id("input-option226")));
		select.selectByIndex(1);

		// Creating element of the quantity text box
		WebElement quantity = driver.findElement(By.id("input-quantity"));

		// Entering value 5 for quantity
		quantity.clear();// clearing the value of the quantity
		quantity.sendKeys("5");

		// creating element of the addToCart button and clicking on it
		WebElement addToCart = driver.findElement(By.id("button-cart"));
		addToCart.click();

		// Checking to see if we can click on the cart button
		WebElement cartBtn = driver.findElement(By.id("cart-total"));
		cartBtn.click();
		WebElement crossBtnOnTheCart = driver.findElement(By.xpath("//button[@title='Remove']"));
		crossBtnOnTheCart.click();

	}

}
