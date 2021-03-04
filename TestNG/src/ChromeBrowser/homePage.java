package ChromeBrowser;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selectors.homeSelectors;
import Selectors.productSelectors;
import Selectors.searchResultSelectors;

import org.openqa.selenium.interactions.Actions;

import Utils.LibraryUtils;

public class homePage {

    @Test
	public void testHome()
	{
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		final DesiredCapabilities dc = DesiredCapabilities.chrome();
		Properties properties = new Properties();
	       try(FileReader reader =  new FileReader("config")) {
	           
	           properties.load(reader);
	          
	          }catch (Exception e) {;
	          e.printStackTrace();
	          }
	     
		
		dc.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions() {
		{
		    setExperimentalOption("mobileEmulation", new HashMap<String, Object>() {
		            {
		                put("deviceName", properties.getProperty("deviceName"));
		            }
		        });
		    }
		});
		
		
		WebDriver driver = new ChromeDriver(dc);
		driver.get(properties.getProperty("siteURL"));
		
		try {
			Thread.sleep(50000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(driver.getTitle());
		
		LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.locationButton)), 25).click();//click to add to cart button

		try {
			Thread.sleep(10000);
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
		
		
	
		try {//Test the search process
			
		    LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.searchArea)), 25).click();
			LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector(homeSelectors.searchTextbox)), 25).sendKeys(properties.getProperty("searchItem"));
			
			try {//sleep the thread to see the input
				Thread.sleep(500);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			 LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.searchButton)), 25).click();//start the search by clicking the button
//			LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.searchTextbox)), 1).sendKeys(Keys.ENTER);
		
			try {
				Thread.sleep(30000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(searchResultSelectors.firstItem)), 25).click();//click to the first element
//			Actions act = new Actions(driver);
//			act.moveToElement(driver.findElement(By.xpath(searchResultSelectors.firstItem))).click().build().perform();
			
			try {
			Thread.sleep(30000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(productSelectors.addToCart)), 25).click();//click to add to cart button

		}
		catch (NoSuchElementException | TimeoutException  ex) {
		       
		        Assert .fail("search process has failed");

		    }
			
	
	
}
}

