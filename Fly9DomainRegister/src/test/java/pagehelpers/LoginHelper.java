package pagehelpers;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import locators.LoginLocators;
import utils.DriverHelper;

public class LoginHelper extends DriverHelper 
{
	
	public LoginHelper(WebDriver driver) 
	{
		super(driver);		
	}
	
	/**
	  * Enter email for login
	  * @author Varesh
	  * @param email email for login
	  */
	public void enterEmail(String email)
	{
		WaitForElementPresent(LoginLocators.EMAIL, 10);
		sendKeys(LoginLocators.EMAIL, email);
	}
	
	/**
	  * Enter password for login
	  * @author Varesh
	  * @param pass password for login
	  */
	public void enterPassword(String pass)
	{
		sendKeys(LoginLocators.PASSWORD, pass);
	}
	
	/**
	  * Click on Login button
	  * @author Varesh
	  */
	public void clickLogin()
	{
		clickOn(LoginLocators.LOGIN);
		waitForLoad(2000);
	}
	
	/**
	  * Click on Logout link
	  * @author Varesh
	  */
	public void clickLogout()
	{
		waitForLoad(2000);
		try
		{
			clickOn(LoginLocators.LOGOUT);
			WaitForElementPresent(LoginLocators.LOGIN, 10);
		}
		catch(Exception e)
		{
			clickOn(LoginLocators.LOGOUT);
			WaitForElementPresent(LoginLocators.LOGIN, 10);
		}
	}
	
	/**
	  * Verify user logged in successfully
	  * @author Varesh
	  */
	public void verifyUserLogin()
	{
		WaitForElementPresent(LoginLocators.LOGOUT, 10);
		Assert.assertTrue(isElementPresent(LoginLocators.LOGOUT));
	}
	
	/**
	  * Enter email for login
	  * Enter password for login
	  * Click on Login button
	  * @author Varesh
	  */
	public void loginToApp(String email, String password)
	{
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	}
}
