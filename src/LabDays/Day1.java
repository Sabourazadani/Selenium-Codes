package LabDays;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {

	public static void main(String[] args) {
		/*
		 --> driver.navigate() navigates to an URL and It will not wait till the whole page gets loaded 
		 --> driver.get() method is used to open an URL and it will wait till the whole page gets loaded.
		 
		 ->  XPath in Selenium is an XML path used for navigation through the HTML structure of the page. 
		 	It is a syntax or language for finding any element on a web page using XML path expression. 
		 	XPath can be used for both HTML and XML documents to find the location of any element on a 
		 	web-page using HTML DOM structure.
		 	
		 	A single slash '/' anywhere in XPath signifies to look for the element immediately inside its 
		 	parent element. A double slash '//' signifies to look for any child or any grand-child 
		 	(descendant) element inside the parent element.
		 	
		 	References
		 	https://www.guru99.com/xpath-selenium.html#3
		 	https://developer.mozilla.org/en-US/docs/Web/HTML/Element
		 */
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		String HomePageURL = "http://www.google.com/";
		driver.navigate().to(HomePageURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		
		

	}

}
