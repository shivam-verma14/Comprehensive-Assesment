package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CAssesment {
	WebDriver driver;
	
	@Test
	public void FindHotel() throws InterruptedException {
		
	      System.setProperty("webdriver.chrome.driver","C:\\browser\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      // browser type and chromedrover.exe path as parameters
	      String url = "https://www.marriott.com/default.mi";
	      driver.get(url);
	      Actions a=new Actions(driver);
	      a.moveToElement(driver.findElement(By.className("m-header__container"))).click().build().perform();
	      
	      
	      //find hotel
	      
	      Thread.sleep(5000);
	      //click on Find hotel button
	      driver.findElement(By.xpath("//form[@action='/search/submitSearch.mi'] //button[@type='submit']")).click();
	      //get the destination sapce to put some value
	      WebElement destination=driver.findElement(By.xpath("(//input[@placeholder='Where do you want to go?'])[2]"));
	      Thread.sleep(2000);
	      //send values for destination
	      destination.sendKeys("Bang");
	      Thread.sleep(2000);
	      //select the second location from top
	      destination.sendKeys(Keys.ARROW_DOWN);
	      //press enter after selecting the destination
	      destination.sendKeys(Keys.ENTER);
	      Thread.sleep(2000);
	      //click on date to select date
          driver.findElement(By.xpath("//div[@data-takeover-label='Dates'] //input[contains(@id,'hotel-fromDate')]")).click();
      
          List<WebElement> ddd = driver.findElements(By.xpath("//div[@class='td-elem']"));
          //traverse the dates and select a specific date accordingly
          for( WebElement de : ddd){	
				//select 23 from the table
			if(de.findElement(By.className("t-date-value")).getText().equals("23")){
				de.click();
				break;
			}
			}
		    
			List<WebElement> checkOutDate = driver.findElements(By.xpath("(//table[@class='t-table-condensed'])[2] //div[@class='td-elem']"));
			//traverse the dates and select a specific date accordingly
			for( WebElement de : checkOutDate){	
				//select 23 from the table
			if(de.findElement(By.className("t-date-value")).getText().equals("23")){
				de.click();
				break;
			}
			}
			//select on guest and room bar 
			driver.findElement(By.xpath("//a[@aria-label='Rooms & Guests']")).click();
			//click on rooms + symbol to add a room
			driver.findElement(By.xpath("//a[@aria-label='Add Rooms']")).click();
			//click on + for adults per room twice
			driver.findElement(By.xpath("//a[@aria-label='Add Adults Per Room']")).click();
			driver.findElement(By.xpath("//a[@aria-label='Add Adults Per Room']")).click();
			
//			driver.findElement(By.xpath("//a[@aria-label='Rooms & Guests']")).click();
			//click on special rates list
			driver.findElement(By.xpath("//a[@aria-label='Special Rates']")).click();
			//select senior discount
			WebElement special=driver.findElement(By.xpath("//input[@aria-label='Senior Discount']"));
			//move to senior discount and then click
	        a.moveToElement(special).click().build().perform();
	        //click of brands tag to select brands
	        driver.findElement(By.cssSelector("span[class='l-h-toggle-brand-text']")).click();
	        //selecting two brands from that section
	        WebElement brand=driver.findElement(By.cssSelector("label[title='Delta Hotels and Resorts']"));
	        a.moveToElement(brand).click().build().perform();
	        WebElement brand1=driver.findElement(By.cssSelector("input[name='luxuryLabel_LC']"));
	        a.moveToElement(brand1).click().build().perform();
	        //close the brand tag
	        driver.findElement(By.cssSelector("span[class='l-h-toggle-brand-text']")).click();
	        //tick the userreward checkbox
	        driver.findElement(By.cssSelector("input[name='useRewardsPoints']")).click();
	        //click on find hotel button
	        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	        //get hotels that are displayed
	        List<WebElement> hotels=driver.findElements(By.xpath("//span[@class='l-property-name']"));
	        //display all the hotels
	        for(WebElement hotel : hotels) {
	        	System.out.println(hotel.getText());
	        }	
	}
	
	@Test
	public void joinPage() throws InterruptedException {
		String url = "https://www.marriott.com/default.mi";
		driver.get(url);
		Actions a=new Actions(driver);
		
	// join code 
      //fetch the sign in or join
      WebElement destination1=driver.findElement(By.xpath("(//a[@aria-label='Sign In or Join'])[2]"));
      a.moveToElement(destination1).click().build().perform();
      Thread.sleep(2000);
      //click on join in
      a.moveToElement(driver.findElement(By.xpath("//a[@data-description='Join']"))).click().build().perform();
      Thread.sleep(2000);
      //fill first name
      driver.findElement(By.id("field-first-name")).sendKeys("Anuj");
      //fill last name
      driver.findElement(By.id("field-last-name")).sendKeys("Singh");
      Thread.sleep(2000);
      a.moveToElement(driver.findElement(By.className("selectric"))).click().build().perform();
      Thread.sleep(2000);
      //get the list to select countries
      List<WebElement> allProduct = driver.findElements(By.xpath("//li[@role='option']"));
		
		for( WebElement lii : allProduct){
			
			if(lii.getText().equals("China")) {
				lii.click();
				break;
			}
		}
	  Thread.sleep(2000);
	  //enter email
      driver.findElement(By.id("field-email")).sendKeys("Singh@email.com");
      //enter password
      driver.findElement(By.id("field-password")).sendKeys("Singh@123");
      Thread.sleep(1000);
      //reenter the password
      driver.findElement(By.id("field-password-confirmation")).sendKeys("Singh@123");
      //check if portal is displayed 
      if(driver.findElement(By.id("field-postal")).isDisplayed())
    	  //enter portal value
      driver.findElement(By.id("field-postal")).sendKeys("668786");
      //check if telephone number option is available
      if(driver.findElement(By.id("field-telephone-number")).isDisplayed()){ 
    	  //enter value
    	  (driver.findElement(By.id("field-telephone-number"))).sendKeys("342345");
      }
      Thread.sleep(2000);
      //select the checkboxes
      driver.findElement(By.id("field-email-promotional-opt-in")).click();
      driver.findElement(By.id("field-email-third-party-opt-in")).click();
      driver.findElement(By.id("requiredConsent-cnPersonalDataRequired")).click();
      driver.findElement(By.id("requiredConsent-cnCrossBorderPersonalDataRequired")).click();
      //click on join button
      driver.findElement(By.id("enroll-join")).click();	 
     
}
	
	@Test
	public void trip() throws InterruptedException {
	      String url = "https://www.marriott.com/default.mi";
	      driver.get(url);
	      Actions a=new Actions(driver);
	      a.moveToElement(driver.findElement(By.className("m-header__container"))).click().build().perform();
	      //click on my trip
	      driver.findElement(By.xpath("(//a[@data-dialog-id='m-header-mytrip-dialog-header'])[2]")).click();
	      Thread.sleep(2000);
	      //enter number in trip window
	      driver.findElement(By.xpath("//input[@id='confirmationNumber']")).click();
	      driver.findElement(By.xpath("//input[@id='confirmationNumber']")).sendKeys("765765");
	      WebElement cin=driver.findElement(By.id("cInDate"));
	      cin.click();
	      List<WebElement>cinDates=cin.findElements(By.xpath("//div[@role='gridcell']"));
	      for(WebElement dee: cinDates) {
	    	  if(dee.getText().equals("23")) {
	    		  dee.click();
	    		  break;
	    	  }
	      }
	      
	      driver.findElement(By.id("firstName")).click();
	      driver.findElement(By.id("firstName")).sendKeys("John");
	      driver.findElement(By.id("lastName")).click();
	      driver.findElement(By.id("lastName")).sendKeys("Michael");
	      Thread.sleep(2000);
	      driver.findElement(By.id("find-reservaton")).click();
	      
	      
	      driver.findElement(By.id("fName")).sendKeys("John");
	      driver.findElement(By.id("lName")).sendKeys("Michael");
	      driver.findElement(By.id("cfNumber")).sendKeys("234234");
	      Thread.sleep(2000);
	      WebElement cin2=driver.findElement(By.xpath("//input[@id='cInDates']"));
	      cin2.click();
        Thread.sleep(2000);
        cin2.click();
	      List<WebElement>cinDates2=cin2.findElements(By.xpath("//div[@role='gridcell']"));
	      for(WebElement dee: cinDates2) {
	    	  if(dee.getText().equals("18")) {
	    		  dee.click();
	    		  break;
	    	  }
	      }
	      driver.findElement(By.id("lookup-submit-btn")).click();
	}

	}