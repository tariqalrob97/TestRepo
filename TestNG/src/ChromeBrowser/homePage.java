package ChromeBrowser;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
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
	
		System.out.println(driver.getTitle());
		
		try {//Test if the main elements are loaded correctly
	
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#orderStatus > a > span")), 25);//The order icon
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#wishlist > a")), 25);//wish list
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#searchButton > img")), 25);//search button
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#searchBox")), 25);//search text box
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#logo1 > a > img")), 25);//the logo
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#bdheader > div > div.bottomline > div.left > div.DesignServices > a")), 25);//design services
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-72 > a > span.gwt-menuItem-link-categoryNameSplit2")), 25);// menu item1

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-135 > a")), 25);// menu item2
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-162 > a > span.gwt-menuItem-link-categoryNameSplit2")), 25);// menu item3
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-184 > a > span.gwt-menuItem-link-categoryNameSplit2")), 25);// menu item4
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-221 > a > span.gwt-menuItem-link-categoryNameSplit1")), 25);// menu item5

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-237 > a > span.gwt-menuItem-link-categoryNameSplit1")), 25);// menu item6

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-276 > a > span.gwt-menuItem-link-categoryNameSplit2")), 25);// menu item7

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-285 > a > span.gwt-menuItem-link-categoryNameSplit2")), 25);// menu item8

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-294 > a > span.gwt-menuItem-link-categoryNameSplit2")), 25);// menu item9

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt-uid-309 > a > span.gwt-menuItem-link-categoryNameSplit2")), 25);// menu item10

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#main-link > img")), 25);// main image

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#socialmedia")), 25);// social media area

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#customer-service-bar > div > div:nth-child(1) > p > a")), 25);// phone number

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#customer-service-bar > div > div:nth-child(2) > p > a")), 25);// chat

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#customer-service-bar > div > div:nth-child(3) > p > a")), 25);// email

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#customer-service-bar > div > div:nth-child(4) > p > a")), 25);// design services

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#gwt_country_changer > a > span")), 25);// shipping location

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#emailSignUp_label")), 25);// sign up by email label

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#emailSignUp")), 25);//  sign up by email text box

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#emailSignUpSubmitButton")), 25);//  sign up by email button
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#footer")), 25);// the footer

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#row-catgegoy-grid")), 25);// grid

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#unit3 > div")), 25);
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#footer > div.line3 > div.right > div.conditionsOfUse > a")), 25);//conditions Of Use

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#popularSearches > a")), 25);//popular searches 
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#privacyAndSecurity > a")), 25);//privacy & security

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#siteMap > a")), 25);//site map

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#sourceCode")), 25);//source code

		
		}
		catch (NoSuchElementException | TimeoutException  ex) {
	       // System.out.println("Some Elements do loaded");
	        Assert .fail("Some Elements do loaded");

	    }
	
		try {//Test the search process
			
			LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#searchBox")), 25).sendKeys(properties.getProperty("searchItem"));
			LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("#searchButton > img")), 25).click();
			
			LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("#unbxd-index-0 > div > div.gwt-product-info-panel-details-panel > div > div > h2 > a")), 25).click();//wait until the next page is loaded then click to an item
			
			
		}
		catch (NoSuchElementException | TimeoutException  ex) {
		       
		        Assert .fail("search process has failed");

		    }
			
	
	
}
}

