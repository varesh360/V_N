package pagehelpers;

import org.openqa.selenium.WebDriver;
import locators.ResetPasswordLocators;
import utils.DriverHelper;
import utils.PropertyReader;

public class ResetPasswordHelper extends DriverHelper 
{
	
	public ResetPasswordHelper(WebDriver driver) 
	{
		super(driver);		
	}
	PropertyReader propertyReader = new PropertyReader();
		
	/**
	  * Reset Password from link
	  * @author Varesh
	  */
	public void resetPassword()
	{
		String useremail =propertyReader.readApplicationFileForUsers("Useremail");
		clickOn(ResetPasswordLocators.RESETPASSWORDLINK);
		sendKeys(ResetPasswordLocators.ENTEREMAIL, useremail);
		clickOn(ResetPasswordLocators.RESETPASSWORDBTN);
		WaitForElementPresent(ResetPasswordLocators.SUCCESSMESSAGE, 10);
		WaitForElementNotPresent(ResetPasswordLocators.SUCCESSMESSAGE, 10);
	}
	
	
	/**
	  * Get the new password link and then changed the user password
	  * @author Varesh
	  */
	public void changePassword(String Password)
	{
		String useremail =propertyReader.readApplicationFileForUsers("Useremail");
		getWebDriver().navigate().to("http://www.yopmail.com");
		sendKeys(ResetPasswordLocators.MAILLOGIN, useremail);
		clickOn(ResetPasswordLocators.CHECKINBOX);
		clickOn(ResetPasswordLocators.CHKFORNEWEMAIL);
		getWebDriver().switchTo().frame("ifmail");
		String password = getText(ResetPasswordLocators.PASSWORDLINK);
		getWebDriver().navigate().to(password);
		sendKeys(ResetPasswordLocators.NEWPASSWORD, Password);
		sendKeys(ResetPasswordLocators.CONFIRMPASSWORD, Password);
		clickOn(ResetPasswordLocators.RESETBTN);
		WaitForElementPresent(ResetPasswordLocators.SUCCESSMESSAGE, 10);
		WaitForElementNotPresent(ResetPasswordLocators.SUCCESSMESSAGE, 10);
	}
}
