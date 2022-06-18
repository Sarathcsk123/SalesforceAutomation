package week2day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class S07_69_ArchitectCertifications {

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
		
		 //        2. Login with the credentials
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		
		//  3.  Click on Learn More link in Mobile Publisher
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		// 4.  Navigate to  Create and publish custom-branded mobile apps.
		
		  Set<String> windowhandles = driver.getWindowHandles();
		   for (String eachHandle : windowhandles) {
			   System.out.println(eachHandle);
			   
		   }
		   
		   List<String> listofHandles = new ArrayList<String>(windowhandles);
		  String secondWindHandle = listofHandles.get(1);
		  
		   driver.switchTo().window(secondWindHandle);
		
		// 5. Mouse hover on resources and select SalesForce Certification
		   
		   Thread.sleep(3000);     
		      String title = driver.getTitle();
			   System.out.println(title);
		  	
			   Shadow shadow =new Shadow(driver);
			   Thread.sleep(3000); 
		       WebElement	sd =  shadow.findElementByXPath("//span[text()='Resources']");
			   sd.click();
			   Actions  act =new Actions(driver);
			   act.moveToElement(sd).build().perform(); 
			   
			   shadow.findElementByXPath("//span[text()='Salesforce Certification']").click();
			   
		// 6.  Select Salesforce Architect
			   
			   Set<String> windowhandles1 = driver.getWindowHandles();
			   for (String eachHandle1 : windowhandles1) {
				   System.out.println(eachHandle1);
				   
			   }
			   
			   List<String> listofHandles1 = new ArrayList<String>(windowhandles1);
			   
				  String thirdWindHandle = listofHandles1.get(2);				  
				  driver.switchTo().window(thirdWindHandle);
	   
				  driver.findElement(By.xpath("//div[@class='roleMenu-item_text'][text()='Architect']")).click();  
		
		// 8.  Verify the Page tile after selecting Architect		  
				  Thread.sleep(3000);
				   String title2 = driver.getTitle();
				   System.out.println(title2);
	   
		// 9. Verify the Certifications listed for Architect
				   
					System.out.println("Following are the certification available for Architect :");
		               
					String	txt=driver.findElement(By.xpath("//a[text()='Application Architect']")).getText();
						System.out.println("A."+txt);
						String	txt1=driver.findElement(By.xpath("//a[text()='B2B Solution Architect']")).getText();
						System.out.println("B."+txt1);
						String	txt2=driver.findElement(By.xpath("//a[text()='B2C Solution Architect']")).getText();
						System.out.println("C."+txt2);
						String	txt3=driver.findElement(By.xpath("//a[text()='B2C Commerce Architect']")).getText();
						System.out.println("D."+txt3);
						String	txt4=driver.findElement(By.xpath("//a[text()='Heroku Architect']")).getText();
						System.out.println("E."+txt4);
						String	txt5=driver.findElement(By.xpath("//a[text()='Technical Architect']")).getText();
						System.out.println("F."+txt5);
				   
				   
				   

	}

}
