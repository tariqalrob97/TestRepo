package ChromeBrowser;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Selectors.homeSelectors;
import Selectors.productSelectors;
import Selectors.searchResultSelectors;

import org.openqa.selenium.interactions.Actions;

import Utils.LibraryUtils;
import screenshots.screenshotHandle;
import template.initializingBrowser;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class homePage implements initializingBrowser, ITestListener {
	
	WebDriver driver ;

	public void clickOnLocation(WebDriver driver)
	{
		try {
			Thread.sleep(50000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.locationButton)), 25).click();//click to add to cart button
	}
	
	
	public void searchForItem(WebDriver driver, Properties properties)
	{
		try {
	            LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.searchArea)), 25).click();
				LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.searchTextbox)), 25).sendKeys(properties.getProperty("searchItem"));
				
				try {//sleep the thread to see the input
					Thread.sleep(500);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				 LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.searchButton)), 25).click();//start the search by clicking the button
			
					
		}
		catch (NoSuchElementException | TimeoutException  ex) {
		       
	        Assert .fail("Failed to enter Item");

	    }
	}
	
	
	public boolean clickOnProduct(WebDriver driver,Properties properties)
	{
		try {
			Thread.sleep(30000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//test if the product match with the input of the search
		String prodName=driver.findElement(By.cssSelector(searchResultSelectors.firstItem)).getText().toString();//get the product name
		
		if(prodName.endsWith(properties.getProperty("searchItem").toString())||prodName.startsWith(properties.getProperty("searchItem").toString()))
		{
			//click to the first element
			try {
				LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(searchResultSelectors.firstItem)), 25).click();
			}
			catch (NoSuchElementException | TimeoutException  ex) {
			       
		        Assert .fail("Failed to click on the product");
		    }
			return true;
		}
		else {
			 System.out.println("The search result does not match");
			 return false;
		}
	}
	
	public void addToCart(WebDriver driver)
	{
		try {
			Thread.sleep(30000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
		LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(productSelectors.addToCart)), 25).click();//click to add to cart button
		}
		catch (NoSuchElementException | TimeoutException  ex) {
		       
	        Assert .fail("Failed to add to cart");
	    }
	}
    @Test
	public void testHome () {

	final DesiredCapabilities dc = initializingBrowser.initializeChromeBrowser ();
		Properties properties = new Properties();
	       try(FileReader reader =  new FileReader("config")) {
	           
	           properties.load(reader);
	          
	          }catch (Exception e) {;
	          e.printStackTrace();
	          }
	
	    driver = new ChromeDriver(dc);
		driver.get(properties.getProperty("siteURL"));
		
  
		
		clickOnLocation(driver);

		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {//Test if the main elements are loaded correctly
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.logo)), 25);//logo
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.orderIcon)), 25);//The order icon
	
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.menu)), 25);//menu
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.searchArea)), 25);//searchArea
	
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.stores)), 25);//stores
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.shopNow)), 25);//  shopNow

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.easter)), 25);// easter
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.sewing)), 25);//sewing
	
    	LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.paperCraft)), 25);//paperCraft
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.baking)), 25);//baking
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.kids)), 25);//kids 

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.knittingAndCrochet)), 25);//knittingAndCrochet

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.craftsAndHobbies)), 25);// craftsAndHobbies

    	LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.digitalCutting)), 25);//digitalCutting

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.artSupplies)), 25);//artSupplies

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.decorAndFrames)), 25);//decorAndFrames

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.wedding)), 25);//wedding
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.occations)), 25);//occations

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.offers)), 25);//offers
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.ideas)), 25);//ideas

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.mainImage)), 25);//mainImage
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.clearance)), 25);//clearance

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.newArrivals)), 25);//newArrivals
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.trustpiolt)), 25);//trustpiolt

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.like)), 25);//like
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.hobbycraftClub)), 25);//hobbycraftClub
		}
		catch (NoSuchElementException | TimeoutException  ex) {
	       // System.out.println("Some Elements do loaded");
	        Assert .fail("Some Elements do loaded");

	    }

	
		//Test the search process
		    searchForItem(driver,properties);
			if(clickOnProduct(driver,properties)) {
			addToCart(driver);
			}
			else 
				 System.out.println("Could not add to cart");
			
}
    
   @AfterMethod
   public void teatDown(ITestResult result) throws IOException 
   {
	   if(ITestResult.FAILURE==result.getStatus())
		   screenshotHandle.takeScreenshot(driver,result.getName() );
   driver.quit();
   }
    
}

