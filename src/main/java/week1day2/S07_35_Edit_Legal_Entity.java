package week1day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_35_Edit_Legal_Entity {

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
		
		
		// 4.   Click on the legal Entities tab 
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		
		//5.  Search the Legal Entity 'Salesforce Automation by Your Name' 
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input")).sendKeys("Salesforce Automation by Sarath");
		driver.findElement(By.xpath("//button[@name='refreshButton']")).click();
		
		// 6. Click on the Dropdown icon and Select Edit
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='branding-actions actionMenu popupTargetContainer uiPopupTarget uiMenuList forceActionsDropDownMenuList uiMenuList--left uiMenuList--default visible positioned']/div/ul/li/a)[1]")).click();

		
		// 7. Enter the Company name as 'Tetsleaf'.

        driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Testleaf");
        
       // 8.  Enter Description as 'SalesForce'.
        
        driver.findElement(By.xpath("(//textarea[@role='textbox'])[2]")).sendKeys("SalesForce");
        
      // 9. Select Status as 'Active'.
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//div[@class='uiMenu'])[4]")).click();
        driver.findElement(By.xpath("(//ul[@class='scrollable']/li)[4]")).click();
        
        String txt = driver.findElement(By.xpath("(//div[@class='uiMenu'])[4]")).getText();
        
        System.out.println(txt);
     // 10. Click on Save
        
        driver.findElement(By.xpath("(//div[@class='actionsContainer']//button)[4]")).click();
        
    
    
    
     
	}

}
