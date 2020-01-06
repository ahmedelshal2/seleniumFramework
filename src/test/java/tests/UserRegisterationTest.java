package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{
		
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration("ali","ahmed","nana2022@gmail.com","123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}
	
	
	@Test(priority=2)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	@Test(priority=3)
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin("nana2022@gmail.com", "123456789");
		
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
