package week1day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_36_Create_LegalEntity_without_mandatoryfields {

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
				driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Legal Entities");
				driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
				
				// 4. Click on the Dropdown icon in the legal Entities tab
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//a[@role='button'][@class='slds-button slds-button_reset'])[27]")).click();
				
				// 5. Click on New Legal Entity
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]")).click();

				// 6. Enter the Company name as 'Tetsleaf'.

                driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Testleaf");
                
                // 7.  Enter Description as 'SalesForce'.
                
                driver.findElement(By.xpath("(//textarea[@role='textbox'])[2]")).sendKeys("SalesForce");
                
                // 8. Select Status as 'Active'.
                
               driver.findElement(By.xpath("(//div[@class='uiMenu'])[3]")).click();
               driver.findElement(By.xpath("(//ul[@class='scrollable']/li)[2]")).click();
               
               // 9. Click on Save
               
               driver.findElement(By.xpath("(//div[@class='actionsContainer']//button)[4]")).click();
               
               // 10. Verify the Alert message (Complete this field) displayed for Name
               
             String txt = driver.findElement(By.xpath("//ul[@class='errorsList']//li")).getText();
             
             System.out.println(txt);
	}

}
