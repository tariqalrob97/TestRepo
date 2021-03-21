package ChromeBrowser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selectors.accountSelectors;
import Utils.LibraryUtils;
import template.initializingBrowser;
import util.TestUtil;

public class Signup {
	
	boolean validEmail=true;
	@DataProvider
	public Object[][] getSignupnData() throws EncryptedDocumentException, IOException
	{
		Object data[][]=TestUtil.getTestData("signup");
		return data;
	}
	
	
@Test(dataProvider="getSignupnData")
public void registerationTest(String email,String firstName,String lastName, String password, String confirmPassword )
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
     accessTheAccount.goToSigninRegisterPage(driver);
    
   
     //enter the email
     if(email=="")
    	 validEmail=false;//to know that we didn't move to the next page
	driver.findElement(By.cssSelector(accountSelectors.registerEmailTextbox)).sendKeys(email);
	try {
	driver.findElement(By.cssSelector(accountSelectors.createAccountButton)).click();
	}
	catch(StaleElementReferenceException e)

	{
		System.out.print("This is not valid email");
		 validEmail=false;//to know that we didn't move to the next page
	}
	
	try {//wait to load
		Thread.sleep(30000);
	} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
	
if(validEmail){//only try to fill in the info if moved to the next page	
try {
LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.location)),25).click();
} 
catch(NoSuchElementException e)
{
	
}
finally {
try {//wait to load
		Thread.sleep(30000);
	} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}

LibraryUtils.waitForElementToBeClickable(driver,driver.findElement(By.cssSelector(accountSelectors.closeButton)),25).click();	
try {//wait to see the inputs
	Thread.sleep(30000);
} 
catch (InterruptedException e) {
	e.printStackTrace();
}	


//fill the information
driver.findElement(By.cssSelector(accountSelectors.firstNameTextbox)).sendKeys(firstName);
driver.findElement(By.cssSelector(accountSelectors.lastNameTextbox)).sendKeys(lastName);
driver.findElement(By.cssSelector(accountSelectors.password)).sendKeys(password);
driver.findElement(By.cssSelector(accountSelectors.confirmPassword)).sendKeys(confirmPassword);

try {//wait to see the inputs
		Thread.sleep(7000);
	} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
//click the button
driver.findElement(By.cssSelector(accountSelectors.createYourAccountButton)).click();	
}   
     
}
}
}
