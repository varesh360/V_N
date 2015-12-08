package scripts;

import org.testng.annotations.Test;
import pagehelpers.AdminHelper;
import pagehelpers.LoginHelper;
import pagehelpers.ResetPasswordHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class ResetPassword extends DriverTestCase{

	/**
	 * This test case to check the functionality of Reset Password link
	 */
	@Test
	public void testResetPassword() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			AdminHelper adminHelper= new AdminHelper(getWebDriver());
			ResetPasswordHelper resetPasswordHelper= new ResetPasswordHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			String Username =propertyReader.readApplicationFileForUsers("Username");
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Login as Admin user
			loginHelper.loginToApp(AdminUser, AdminPass);
			ExecutionLog.Log("Admin is loggedin");
						
			// Select Users link
			adminHelper.selectUsers();
			ExecutionLog.Log("User section is now opened");
			
			// Click on New User button
			adminHelper.clickNewUserBtn();
			ExecutionLog.Log("Clicked on New User button");
			
			// Add user details with Customer All Role
			adminHelper.addUserDetails(UserPassword);
			ExecutionLog.Log("User details are added with Customer All role");
			
			// Verify new user is created
			adminHelper.verifyNewUserCreated();
			ExecutionLog.Log("New user is created and verified");
			
			// Logout from application
			loginHelper.clickLogout();
			ExecutionLog.Log("Logout from the application");
			
			// Reset the Password
			resetPasswordHelper.resetPassword();
			ExecutionLog.Log("Password is reset and email is sent");
			
			// Change the Password
			resetPasswordHelper.changePassword(ChangePassword);
			ExecutionLog.Log("Password is changed");
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
						
			// Login with changed password
			loginHelper.loginToApp(Username, ChangePassword);
			ExecutionLog.Log("Login with changed password");
			
			// Verify user logged in
			loginHelper.verifyUserLogin();
			ExecutionLog.Log("User is able to login with changed password");
								
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
