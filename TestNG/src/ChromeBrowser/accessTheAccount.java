package ChromeBrowser;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Selectors.accountSelectors;
import Selectors.homeSelectors;
import Utils.LibraryUtils;
import template.initializingBrowser;

public class accessTheAccount {
	
	public void goToSigninRegisterPage(WebDriver driver)
	{
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		 LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(accountSelectors.menuButton)), 25).click();
		 LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.signinOrRegister)),25).click();	
		 try {
				Thread.sleep(10000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			} 
			LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.location)),25).click();		
	}
	
	public void createAccount(WebDriver driver)
	{
		Properties properties = new Properties();
	       try(FileReader reader =  new FileReader("config")) {
	           
	           properties.load(reader);
	          
	          }catch (Exception e) {;
	          e.printStackTrace();
	          }
	       //enter the email
		driver.findElement(By.cssSelector(accountSelectors.registerEmailTextbox)).sendKeys(properties.getProperty("email"));
		driver.findElement(By.cssSelector(accountSelectors.createAccountButton)).click();
		
		try {//wait to load
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
     
     LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.location)),25).click();
     
     try {//wait to load
			Thread.sleep(30000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
     
     LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.closeButton)),25).click();	
		
     //fill the information
     driver.findElement(By.cssSelector(accountSelectors.firstNameTextbox)).sendKeys(properties.getProperty("firstName"));
     driver.findElement(By.cssSelector(accountSelectors.lastNameTextbox)).sendKeys(properties.getProperty("lastName"));
     driver.findElement(By.cssSelector(accountSelectors.password)).sendKeys(properties.getProperty("password"));
     driver.findElement(By.cssSelector(accountSelectors.confirmPassword)).sendKeys(properties.getProperty("password"));
     
     try {//wait to see the inputs
			Thread.sleep(7000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
     //click the button
     driver.findElement(By.cssSelector(accountSelectors.createYourAccountButton)).click();	
		
	}
	
	public void login(WebDriver driver)
	{
		Properties properties = new Properties();
	       try(FileReader reader =  new FileReader("config")) {
	           
	           properties.load(reader);
	          
	          }catch (Exception e) {;
	          e.printStackTrace();
	          } 
	       //enter the email
		 driver.findElement(By.cssSelector(accountSelectors.loginEmailTextbox)).sendKeys(properties.getProperty("email"));
		 //enter the password
	     driver.findElement(By.cssSelector(accountSelectors.loginPassword)).sendKeys(properties.getProperty("password"));
	     //click the button
	     driver.findElement(By.cssSelector(accountSelectors.loginButton)).click();
	}
	
//@Test 
//public void registerationTest()
//{
//	final DesiredCapabilities dc = initializingBrowser.initializeChromeBrowser ();
//	Properties properties = new Properties();
//       try(FileReader reader =  new FileReader("config")) {
//           
//           properties.load(reader);
//          
//          }catch (Exception e) {;
//          e.printStackTrace();
//          }
//
//     WebDriver driver = new ChromeDriver(dc);
//     driver.get(properties.getProperty("siteURL"));
//     try {
//			Thread.sleep(30000);
//		} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//     Setup.clickOnLocation(driver);
//     goToSigninRegisterPage(driver);
//     createAccount(driver);
//     
//
//}
	
	@Test
	public void loginTest()
	{
		final DesiredCapabilities dc = initializingBrowser.initializeChromeBrowser ();
		Properties properties = new Properties();
	       try(FileReader reader =  new FileReader("config")) {
	           
	           properties.load(reader);
	          
	          }catch (Exception e) {;
	          e.printStackTrace();
	          }
	       WebDriver driver = new ChromeDriver(dc);
	     driver.get(properties.getProperty("siteURL"));
	     try {
				Thread.sleep(30000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	     Setup.clickOnLocation(driver);
	     goToSigninRegisterPage(driver);
	     try {
				Thread.sleep(10000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	     LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.closeButton)),25).click();	
	 	
	     login(driver);
	}

}
