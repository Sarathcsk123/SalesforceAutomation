package week2day2;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.record.IterationRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class S07_68_AdministratorCertifications {

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
		
		// 4. Navigate to  Create and publish custom-branded mobile apps.
		
//		          String  mainwindowhandles  = driver.getWindowHandle();
//		      Set<String> Allwindhandle = driver.getWindowHandles();
//		      Iterator<String> iterator = Allwindhandle.iterator();
//		      
//		      while(iterator.hasNext()) {
//		    	String  ChildWindow  = iterator.next();
//		    	if(!mainwindowhandles.equalsIgnoreCase(ChildWindow) ) {
//		    		driver.switchTo().window(ChildWindow);
//		    	}
//		    	
//		      }
		      
		   Set<String> windowhandles = driver.getWindowHandles();
		   for (String eachHandle : windowhandles) {
			   System.out.println(eachHandle);
			   
		   }
		   
		   List<String> listofHandles = new ArrayList<String>(windowhandles);
		  String secondWindHandle = listofHandles.get(1);
		  
		   driver.switchTo().window(secondWindHandle);
		
		
		      
		
         // 5.  Mouse hover on resources and select SalesForce Certification 
		      
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
			   
			   
		 //6.   Navigate to  Certification-Administrator Overview  
			   Set<String> windowhandles1 = driver.getWindowHandles();
			   for (String eachHandle1 : windowhandles1) {
				   System.out.println(eachHandle1);
				   
			   }
			   
			   List<String> listofHandles1 = new ArrayList<String>(windowhandles1);
			   
				  String thirdWindHandle = listofHandles1.get(2);				  
				  driver.switchTo().window(thirdWindHandle);
	   
				   String title2 = driver.getTitle();
				   System.out.println(title2);
				   
				   
		// 7.  Click on SalesForce Administrator
				   
				driver.findElement(By.xpath("//div[@class='roleMenu-item_text'][text()='Administrator']")).click();
				
		// 8.   Verify the Certifications available for Administrator
				
				System.out.println("Following are the certification available for Administrator :");
               
			String	txt=driver.findElement(By.xpath("//a[text()='Administrator']")).getText();
				System.out.println(txt);
				String	txt1=driver.findElement(By.xpath("//a[text()='Advanced Administrator']")).getText();
				System.out.println(txt1);
				String	txt2=driver.findElement(By.xpath("//a[text()='CPQ Specialist']")).getText();
				System.out.println(txt2);
				String	txt3=driver.findElement(By.xpath("//a[text()='Marketing Cloud Administrator']")).getText();
				System.out.println(txt3);
				String	txt4=driver.findElement(By.xpath("//a[text()='Platform App Builder']")).getText();
				System.out.println(txt4);
				
				
				
				
	}

}
