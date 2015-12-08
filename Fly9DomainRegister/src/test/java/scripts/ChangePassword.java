package scripts;

import locators.ResetPasswordLocators;
import org.testng.annotations.Test;
import pagehelpers.LoginHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class ChangePassword extends DriverTestCase{

	/**
	 * This test case to check the functionality of Change Password link
	 */
	@Test
	public void testChangePassword() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			String Username =propertyReader.readApplicationFileForUsers("Useremail");
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Login as Admin user
			loginHelper.loginToApp(Username, UserPassword);
			ExecutionLog.Log("Admin is loggedin");
			
			// Click on Change Password link
			mouseOver(ResetPasswordLocators.SCREENNAME);
			clickOn(ResetPasswordLocators.CHANGEPASSWORD);
			ExecutionLog.Log("Clicked on Change Password link");
			
			// Change the Password
			sendKeys(ResetPasswordLocators.OLDPASSWORD, UserPassword);
			sendKeys(ResetPasswordLocators.ENTERNEWPASSWORD, UserPassword);
			sendKeys(ResetPasswordLocators.ENTERCONFIRMPASSWORD, UserPassword);
			clickOn(ResetPasswordLocators.SAVEPASSWORD);
			WaitForElementPresent(ResetPasswordLocators.SUCCESSMESSAGE, 10);
			WaitForElementNotPresent(ResetPasswordLocators.SUCCESSMESSAGE, 10);
			clickOn(ResetPasswordLocators.CLOSE);
			ExecutionLog.Log("Password is changed");
			
			// Logout from application
			loginHelper.clickLogout();
			Thread.sleep(3000);
			ExecutionLog.Log("Logout from the application");
			
			// Login as user with changed password		
			loginHelper.loginToApp(Username, UserPassword);
			ExecutionLog.Log("User logged in with new password");
			
			// Verify user logged in with changed password
			loginHelper.verifyUserLogin();
			ExecutionLog.Log("Verified user logged in with changed password");
	}
	
	catch(Error e) 
	{
		captureScreenshot(new Exception().getStackTrace()[0].getMethodName());	
		ExecutionLog.LogErrorMessage(e);			
		throw e;
	} 
	catch(Exception e) 
	{
		captureScreenshot(new Exception().getStackTrace()[0].getMethodName());
		ExecutionLog.LogExceptionMessage(e);			
		throw e;
	}
  }
}
