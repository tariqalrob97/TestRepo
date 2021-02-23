package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestB {
	@BeforeTest
	public void before()
	{//open the browser for example
		System.out.println("@BeforeTest");
		
	}
	
	@AfterTest
	public void after()
	{//close the browser for example
		System.out.println("@AfterTest");
		
	}

	@Test
	public void testB() {
		System.out.println("In the Test");
		String expVal="A";
		String actVal="A";
		Assert.assertEquals(expVal, actVal);
	}
	
}
