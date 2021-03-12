package ExamplesAutomations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMacToCartExampleCheckBoxesRadioButtons {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://tek-school.com/retail/index.php?route=common/home");

		driver.findElement(By.xpath("//*[contains(text(),'Apple Cinema 30\"')]")).click();

		WebElement mediumDropDown = driver.findElement(By.xpath("//input[@value=6]"));
		mediumDropDown.click();

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@id='input-option223']//div//label//input"));
		System.out.println(checkBoxes.size());

		checkBoxes.get(1).click();
		checkBoxes.get(3).click();

		driver.findElement(By.id("input-option208")).clear();
		driver.findElement(By.id("input-option208")).sendKeys("test input");

		driver.findElement(By.id("input-option219")).clear();
		driver.findElement(By.id("input-option219")).sendKeys("2018-01-21");

		for (int day = 15; day <= 25; day++) {
			// clicking on the calendar btn to open and show the calendar table
			driver.findElement(By.xpath("(//*[@class='btn btn-default']//i[@class = 'fa fa-calendar'])[1]")).click();

			// finding the day element and replacing the variable day value and clicking on
			// that element
			driver.findElement(By
					.xpath("(//*[@class='table-condensed'])[1]//tbody//tr//td[@class='day' and text()='" + day + "']"))
					.click();

			// waiting for 1 second to show the execution
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}