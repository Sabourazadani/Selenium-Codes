package JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassJS {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://tekschool.us/contact/");

		Actions a = new Actions(driver);

//		WebElement readMoreBtn = driver.findElement(By.xpath("//*[@class='default-btn' and contains(text(),'Read')]"));
//		a.moveToElement(readMoreBtn).perform();
		// finding the elements
		WebElement messageTextbx = driver.findElement(By.xpath("//textarea[@name='umessage']"));
		WebElement submitBtn = driver.findElement(By.className("submit-btn"));
		WebElement image = driver.findElement(By.xpath("//div[@class='contact-image']//img"));

		// trying to move to the text box and sending some keys
		a.moveToElement(messageTextbx).sendKeys(messageTextbx, "testing action class").build().perform();

		// waiting for 2 seconds
		Thread.sleep(2000);

		// we send some more keys to the text box
		a.sendKeys(messageTextbx, "\nthis is my second line").perform();

		// waiting for 2 seconds
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys("z").build().perform();

		// waiting for 2 seconds
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys("a").build().perform();

		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("c").build().perform();

		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("v").build().perform();

		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("v").build().perform();

		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
//		// click and hold on the button
//		a.clickAndHold(submitBtn).perform();
//		
//		// right click on the image
//		a.contextClick(image).perform();
	}
}