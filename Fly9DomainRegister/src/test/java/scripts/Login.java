package scripts;

import org.testng.annotations.Test;
import pagehelpers.LoginHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class Login extends DriverTestCase{

	/**
	 * This test case for user login into application by using valid credentials
	 */
	@Test
	public void testUserLogin() throws Exception
	{
		try{
			
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			//Enter the email
			loginHelper.enterEmail(Email);
			ExecutionLog.Log("Entered the email");
			
			//Enter the password
			loginHelper.enterPassword(Password);
			ExecutionLog.Log("Entered the password");
			
			//Click on Login
			loginHelper.clickLogin();
			ExecutionLog.Log("Clicked on Login");
			
			// Verify user logged in
			loginHelper.verifyUserLogin();
			ExecutionLog.Log("User is logged in succesfully");
			
			// Logout from application
			loginHelper.clickLogout();
			ExecutionLog.Log("Logged out from application");
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
