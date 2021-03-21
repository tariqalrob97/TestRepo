package ChromeBrowser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selectors.accountSelectors;
import Selectors.homeSelectors;
import Utils.LibraryUtils;
import template.initializingBrowser;
import util.TestUtil;

public class accessTheAccount {
	
	public static void goToSigninRegisterPage(WebDriver driver)
	{
		try {
			Thread.sleep(30000);
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

@DataProvider
public Object[][] getLoginData() throws EncryptedDocumentException, IOException
{
	Object data[][]=TestUtil.getTestData("Login");
	return data;
}
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String email,String password )
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
				Thread.sleep(30000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	     try {
	     LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.closeButton)),25).click();	
	     }
	     catch(NoSuchElementException e)
	     {
	    	 
	     }
	     finally {
	       //enter the email
		 driver.findElement(By.cssSelector(accountSelectors.loginEmailTextbox)).sendKeys(email);
		 //enter the password
	     driver.findElement(By.cssSelector(accountSelectors.loginPassword)).sendKeys(password);
	     //click the button
	     driver.findElement(By.cssSelector(accountSelectors.loginButton)).click();
	     //driver.quit();
	     }
	}

}
