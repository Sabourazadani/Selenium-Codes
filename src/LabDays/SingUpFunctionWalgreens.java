package LabDays;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingUpFunctionWalgreens {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String HomePageURL = "https://www.walgreens.com/";
		driver.navigate().to(HomePageURL);

		WebElement dropDown = driver.findElement(By.xpath("//span[@class='inner-focus hide-on-mobile truncate']"));
		dropDown.click();
		driver.findElement(By.id("pf-dropdown-register")).click();

		//first test : Testing title of the page        
		System.out.println("**************first test : Testing title of the page*********");
		
		String rigTitle = "Create Your Account | Walgreens"; // positive scenario

		// String rigTitle = "Create Your Account | Walmart"; // negative scenario
		String currentTitle = driver.getTitle();
		
		if (currentTitle.equals(rigTitle)) {
			System.out.println(currentTitle);
		} else {
			System.out.println("Not on the right page, terminating the test");
			driver.close();
		}
		
		//Second Test: Drop down menu       
		System.out.println("************Second Test: Drop down menu    ********");
		
		WebElement termCheckbox = driver.findElement(By.id("wag-terms-checkbox"));
		termCheckbox.click();
		
		if (termCheckbox.isSelected()) {
			System.out.println("term of use box is selected");
		} else {
			System.out.println("term of use box is not selected");
		}
		
		WebElement continueBotton = driver
				.findElement(By.xpath("//span[@style='float:right']/a/span[@class='btn mt0 btn__blue']"));
		continueBotton.click();
		
		//Third Test: Warning messages   
		System.out.println("**********Second Test: Drop down menu  ************");
		String fnWarning = "Please enter your first name.";
		String lnWarning = "Please enter your last name.";
		String emailWarning = "Please enter your email address.";
		String passWarning = "Please enter your password.";
		System.out.println("does the page have warnings for the following");
		System.out.println("First name field: " + driver.getPageSource().contains(fnWarning));
		System.out.println("Last name field: " + driver.getPageSource().contains(lnWarning));
		System.out.println("Email field: " + driver.getPageSource().contains(emailWarning));
		System.out.println("Password field: " + driver.getPageSource().contains(passWarning));
		
		//Fourth test: create account
		driver.navigate().refresh();
		driver.findElement(By.name("firstName")).sendKeys("falcon");
		driver.findElement(By.name("lastName")).sendKeys("falcon");
		driver.findElement(By.id("wag-email")).sendKeys("TestFalcon20210@gmail.com");
		driver.findElement(By.name("registerPassword")).sendKeys("Test1234");

		termCheckbox = driver.findElement(By.xpath("//input[@id='wag-terms-checkbox']"));
		termCheckbox.click();
		continueBotton = driver
				.findElement(By.xpath("//span[@style='float:right']/a/span[@class='btn mt0 btn__blue']"));
		continueBotton.click();
		
		//Verify if the account was create.  
		Thread.sleep(5000);
		
		if (driver.getTitle().contains("Your Account | Walgreens")) {
			System.out.println("Congrets, user account have been created.");
		} else {
			System.out.println("User is not in the account page");
			System.out.println("current page: " + driver.getTitle());
		}

		driver.close();
	}
}