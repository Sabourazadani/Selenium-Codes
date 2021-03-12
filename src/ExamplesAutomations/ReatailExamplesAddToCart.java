package ExamplesAutomations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReatailExamplesAddToCart {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String HomePageURL = "http://tek-school.com/retail/index.php?route=common/home";
		driver.get(HomePageURL);

		addItemsToTheCart(driver, "MacBook", 1);
		addItemsToTheCart(driver, "iPhone", 1);

		String rawTotal = driver.findElement(By.id("cart-total")).getText();
		System.out.println(rawTotal);

		String cleanTotal = rawTotal.substring(rawTotal.indexOf("$")).replace("$", "").replace(",", "");
		double total = Double.valueOf(cleanTotal);
		System.out.println("Your total is $" + total + " and your 10% tax will be $" + (total * 0.1));

	}

	public static void addItemsToTheCart(WebDriver driver, String item, int quantity) {
		if (driver.findElement(By.linkText(item)).isDisplayed()) {
			driver.findElement(By.linkText(item)).click();
			driver.findElement(By.id("input-quantity")).clear();
			// convert the int quantity to string and send it to the box
			driver.findElement(By.id("input-quantity")).sendKeys(String.valueOf(quantity));
			driver.findElement(By.id("button-cart")).click();
			driver.findElement(By.id("button-cart")).click();
			driver.findElement(By.linkText("TEST ENVIRONMENT")).click();
		} else {
			System.out.println("item not found");
		}
	}
}