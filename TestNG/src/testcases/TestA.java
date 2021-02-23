package testcases;

import org.testng.annotations.Test;

public class TestA {

	@Test(priority=1)
	public void doLogin()
	{
		System.out.println("Do login Test");
	}
	@Test(priority=2)
	public void doPasswordChange()
	{
		System.out.println("Changing password");	
	}
	
	@Test(priority=3)
	public void doLogout()
	{
		System.out.println("Loging out");
	}
}
