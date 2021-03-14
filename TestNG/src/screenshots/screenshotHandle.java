package screenshots;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class screenshotHandle {
	
	public static void takeScreenshot (WebDriver driver,String fileName ) throws IOException
	{
		//take screenshot and store it as a file format
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy the screenshot to desired location using copy file method
		File screenshotNam=new File("screenshots/"+fileName+".png");
		FileUtils.copyFile(file,screenshotNam ); 
		
		//Reporter.log("The test has been faild -_-");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		Reporter.log("<a href='"+ screenshotNam.getAbsolutePath() + "'> <img src='"+ screenshotNam.getAbsolutePath() + "' height='218' width='140'/> </a>");
	}
	
}
