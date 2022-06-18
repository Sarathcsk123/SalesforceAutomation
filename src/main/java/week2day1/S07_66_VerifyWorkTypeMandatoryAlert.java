package week2day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_66_VerifyWorkTypeMandatoryAlert {

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


		//			1&2. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		 //        3. Login with the credentials
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		//	    	4.Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//			5. Click view All 
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
	
		
		//  6.  Click on Work Types		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(" Work Types");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		
		// 7. Click on New
		
		driver.findElement(By.xpath("//div[@class='slds-col slds-no-flex slds-grid slds-align-top slds-p-bottom--xx-small test-lvmForceActionsContainer']")).click();
		
		//8. Enter Work Type Name as 'Bootcamp'
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Bootcamp");
		
        //9 Save
		
		driver.findElement(By.xpath("(//span[@class=' label bBody'][text()='Save'])[2]")).click();
		
		String txt =driver.findElement(By.xpath(" //ul[@class='errorsList']/li")).getText();
		System.out.println(txt);
		
	}

}
