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
		
		
		
		try {//Test if the main elements are loaded correctly
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#headerBox > div.t-header__bar > div > div.t-header-top.u-flexbox.u-width-full.u-padding-sm > div.u-flexbox.u-width-full.t-header-bar__title > div > a > div.pw-dangerous-html > div > svg")), 25);//logo
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#headerBox > div.t-header__bar > div > div.t-header-top.u-flexbox.u-width-full.u-padding-sm > div.pw-header-bar__actions.t-header-bar__cart > button")), 25);//The order icon
	
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#pwa-my-account-button > button")), 25);//account button
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#headerBox > div.t-header__bar > div > div.t-header-bottom.u-flexbox.u-width-full > div:nth-child(2) > button")), 25);//search button
	
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#pwa-shop-nav-button > button")), 25);//shop
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#main-link > img")), 25);// maim image

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#row-catgegoy-grid")), 25);// category grid
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#module4 > div > div.row.edgey.flex-vertical-align > div.col-lg-9.col-sm-8.col-sm-7.col-xs-12")), 25);
	
    	LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#module4 > div > div.row.edgey.flex-vertical-align > div.col-lg-3.col-sm-4.col-xs-12.text-center")), 25);
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#module4 > div > div.contentModule.template1.theme1 > div > div:nth-child(1)")), 25);
		
		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#field-0")), 25);//sign up by email textbox 

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#EmailSignUpForm > div > div.t-footer__newsletter-button-panel.u-margin-start-sm > button")), 25);//sign up by email button

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#app-footer > footer > div.u-bg-color-neutral-00.u-margin-top-lg.u-margin-bottom-lg.u-padding-start-lg.u-padding-end-lg > div > button")), 25);// shipping location

    	LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#app-footer > footer > div.t-footer__phone.u-margin-bottom-lg.u-text-size-medium.u-flex-none > div.u-flexbox > div.t-footer__phone-number > a")), 25);//phone number

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#app-footer > footer > div.t-footer__phone.u-margin-bottom-lg.u-text-size-medium.u-flex-none > div.c-egain__container > button > div > div > img")), 25);//chat

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#app-footer > footer > div.t-footer__blogsection.u-flexbox > div > div > a:nth-child(1) > div")), 25);

		LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#app-footer > footer > div.t-footer__blogsection.u-flexbox > div > div > a:nth-child(2) > div")), 25);

		}
		catch (NoSuchElementException | TimeoutException  ex) {
	       // System.out.println("Some Elements do loaded");
	        Assert .fail("Some Elements do loaded");

	    }
		
		
	
		try {//Test the search process
			
		
		    LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("#headerBox > div.t-header__bar > div > div.t-header-bottom.u-flexbox.u-width-full > div:nth-child(2) > button")), 25).click();
			
			System.out.println(driver.getTitle());
		
			LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.cssSelector("#search-0")), 25).sendKeys(properties.getProperty("searchItem"));
			
			try {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("#search-0")), 1).sendKeys(Keys.ENTER);
			
			try {
				Thread.sleep(10000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(driver.getTitle());
			
			

			//LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("#app-main > div > div:nth-child(2) > div > div.pw-list.c-product-list-products.pw--borderless > article:nth-child(1) > div > div > div > div > div > article > a > div > div > img")), 25).click();
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//*[@id=\"app-main\"]/div/div[2]/div/div[2]/article[1]/div/div/div/div/div/article/a/div/div/img"))).click().build().perform();
			
			
			
		}
		catch (NoSuchElementException | TimeoutException  ex) {
		       
		        Assert .fail("search process has failed");

		    }
			
	
	
}
}

