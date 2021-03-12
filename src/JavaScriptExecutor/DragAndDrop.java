package JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement item1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement item2 = driver.findElement(By.xpath("//div[@id='droppable']"));

//		a.dragAndDrop(item1, item2).build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(item1));
		wait.until(ExpectedConditions.visibilityOf(item2));
		a.clickAndHold(item1).moveToElement(item2).release().build().perform();

	}

}
