package ExamplesAutomations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		String HomePageURL = "http://tek-school.com/hotel/";
		driver.get(HomePageURL);
		driver.manage().window().maximize();

		WebElement hotelDropDown = driver.findElement(By.id("id_hotel_button"));
		hotelDropDown.click();
		driver.findElement(By.className("hotel_name")).click();

		// select.selectByValue("2");
		// select.selectByIndex(0);
		// select.selectByVisibleText("Hotel California");

	}

}
