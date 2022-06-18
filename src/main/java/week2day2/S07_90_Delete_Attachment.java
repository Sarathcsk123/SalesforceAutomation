package week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_90_Delete_Attachment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Open Browser
		WebDriverManager.chromedriver().setup();
		// Disable Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		//			1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		//			2. Click on toggle menu button from the left corner		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//			3.Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[@class='slds-truncate'][text()='Sales']")).click();
		
		//			4. Click on Campaigns tab 
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a/span[text()='Campaigns']/ancestor::one-app-nav-bar-item-root")).click();
//        driver.findElement(By.xpath("(//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'])[7]")).click();
        
        //			5. Click Bootcamp link
        
        driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
        
        //			6.	Click on View All link in the Attachments section
        
        driver.findElement(By.xpath("//div/span[text()='View All']")).click();
        
        //			7.
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='slds-icon_container slds-icon-utility-down'])[10]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul/li/a[@title='Delete']")).click();	
        
        //			8.
        
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        
        // 			9. 
		 String txt =driver.findElement(By.xpath("//div[@data-key='success']/div//span")).getText();
		 
		 System.out.println(txt);
	}

}
