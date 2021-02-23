package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestC {
	@Test(dataProvider="getData"/*to connect the test case with the dataProvider*/)
	public void loginTest(String username, String password, String browser)// the # of parameters should be the same as the # of columns in the 2D array
	{
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object[2][3];
		//1st row
		data[0][0]="User1";
		data[0][1]="Pass1";
		data[0][2]="Mozilla";
		
		//2nd row 
		data[1][0]="User2";
		data[1][1]="Pass2";
		data[1][2]="Chrome";
		
		return data;
		
	}

}
