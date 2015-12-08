package scripts;

import org.testng.annotations.Test;
import pagehelpers.DashboardHelper;
import pagehelpers.LoginHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class Messages extends DriverTestCase{

	/**
	 * This test case to verify the Messages section
	 */
	@Test
	public void testMessagesSection() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			DashboardHelper dashBoardHelper= new DashboardHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Enter the email
			loginHelper.loginToApp(Email, Password);
			ExecutionLog.Log("Entered the email");
			
			// Click on Dashboard tab
			dashBoardHelper.clickMessagesTab();
			ExecutionLog.Log("Clicked on Dashboard tab");
			
			// Verify Domain section with Active and Soon Expiring options are present
			dashBoardHelper.clickMessageLink();
			ExecutionLog.Log("Domain section with Active and Soon Expiring options are present");
			
			// Verify Transfers section with In Progress and Action Required options are present
			dashBoardHelper.verifyMessageWindowOpen();
			ExecutionLog.Log("Transfers section with In Progress and Action Required options are present");
			
			// Logout from application
			loginHelper.clickLogout();
			ExecutionLog.Log("Logout from the application");
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
