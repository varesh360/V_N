package scripts;

import org.testng.annotations.Test;
import pagehelpers.AdminHelper;
import pagehelpers.LoginHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class AddCustomerAndUser extends DriverTestCase{

	/**
	 * This test case to Search for one or more domains
	 */
	@Test
	public void testAddCustomerAndUser() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			AdminHelper adminHelper= new AdminHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Login as Admin user
			loginHelper.loginToApp(AdminUser, AdminPass);
			ExecutionLog.Log("Admin is loggedin");
			
			// Select Customers
			adminHelper.selectCustomers();
			ExecutionLog.Log("Customers link is clicked");
			
			// Click on New Customer button
			adminHelper.clickNewCustomerBtn();
			ExecutionLog.Log("Clicked on New Customer button");
			
			// Enter all the required details
			adminHelper.addNewCustomer(AccountName, Name, CustEmail, CustPhone);
			ExecutionLog.Log("All the required details are entered");
			
			// Verify new customer is added
			adminHelper.verifyNewCustomerAdded(AccountName, Name, CustEmail, CustPhone);
			ExecutionLog.Log("New customer is added");
			
			// Select the Added Customer from drop down
			adminHelper.selectAddedCustomer();
			ExecutionLog.Log("Added new customer is selected");
			
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
								
			// Login as User
			adminHelper.loginAsUser(UserPassword);
			ExecutionLog.Log("Logged in as new user");
			
			// Select Users section
			adminHelper.selectUsers();
			ExecutionLog.Log("Users section is opened");
			
			// Select the user check box
			adminHelper.selectUserCheckbox();
			ExecutionLog.Log("User checkbox is selected");
			
			// Edit user details
			adminHelper.editUser(EditScreenName);
			ExecutionLog.Log("Edit the user details");
			
			// Verify user details are edited
			adminHelper.verifyUserDeatilsEdited(EditScreenName);
			ExecutionLog.Log("User details are edited and verified");
			
			// Enable Two Step Authentication
			adminHelper.enableTwoStepAuthentication();
			ExecutionLog.Log("Enabled Two Step Authentication");
			
			// Logout from application
			loginHelper.clickLogout();
			ExecutionLog.Log("Logout from the application");
											
			// Login as User
			adminHelper.loginAsUser(UserPassword);
			ExecutionLog.Log("Logged in as new user");
			
			// Two Step Authentication page is opened
			adminHelper.verifyTwoStepWindow();
			ExecutionLog.Log("Two Step Authentication page is opened");
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
