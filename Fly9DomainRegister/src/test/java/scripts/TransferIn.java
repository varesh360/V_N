package scripts;

import org.testng.annotations.Test;
import pagehelpers.DashboardHelper;
import pagehelpers.LoginHelper;
import pagehelpers.OrdersHelper;
import pagehelpers.TransferHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class TransferIn extends DriverTestCase{

	/**
	 * This test case to add and delete domain on Transfers In section
	 */
	@Test
	public void testTransfersInSection() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			DashboardHelper dashBoardHelper= new DashboardHelper(getWebDriver());
			TransferHelper transferHelper= new TransferHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Enter the email
			loginHelper.loginToApp(Email, Password);
			ExecutionLog.Log("Entered the email");
			
			// Click on Transfers In tab
			dashBoardHelper.clickTransferInTab();
			ExecutionLog.Log("Clicked on Transfers In tab");
			
			//Enter a domain name
			transferHelper.enterDomainName();
			ExecutionLog.Log("Domain name is entered");
			
			// Click on Add Domain button
			transferHelper.clickAddDomain();
			ExecutionLog.Log("Clicked on Add Domain button");
			
			// Verify domain is added
			transferHelper.verifyDomainAdded();
			ExecutionLog.Log("Domain is added");
			
			// Delete the Domain
			transferHelper.deleteDomain();
			ExecutionLog.Log("Delete added domain");
			
			// Verify added domain is delete
			transferHelper.verifyAddedDomainDeleted();
			ExecutionLog.Log("Domain is deleted");
			
			//Enter a domain name
			transferHelper.enterDomainName();
			ExecutionLog.Log("Domain name is entered");
			
			// Click on Add Domain button
			transferHelper.clickAddDomain();
			ExecutionLog.Log("Clicked on Add Domain button");
			
			// Verify domain is added
			transferHelper.verifyDomainAdded();
			ExecutionLog.Log("Domain is added");
			
			// Click on Transfer to AppDetext Vault button
			transferHelper.clickTransferToAppDetexVault();
			ExecutionLog.Log("Clicked on Transfer to AppDetext Vault button");
			
			// Click on Initiate The Transfer button
			transferHelper.clickInitateTheTransfer();
			ExecutionLog.Log("Clicked on Initiate The Transfer button");
			
			// Click on Dashboard tab
			dashBoardHelper.clickDashboardTab();
			ExecutionLog.Log("Clicked on Dashboard tab");
			
			// Click on Transfers Tab
			dashBoardHelper.clickTransfersTab();
			ExecutionLog.Log("Clicked on Transfers tab");
			
			// Select Added transfer
			transferHelper.selectAddedTransfer();
			ExecutionLog.Log("Selected the transfer domain");
			
			// Update the Auth Code
			transferHelper.updateAuthCode();
			ExecutionLog.Log("Auth Code Updated");
			
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
	
	/**
	 * This test case to add and delete domain on Transfers In section
	 */
	@Test
	public void testDeleteTransfer() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			TransferHelper transferHelper= new TransferHelper(getWebDriver());
			DashboardHelper dashBoardHelper= new DashboardHelper(getWebDriver());
			OrdersHelper ordersHelper= new OrdersHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Enter the email
			loginHelper.loginToApp(Email, Password);
			ExecutionLog.Log("Entered the email");
			
			// Click on Transfers In tab
			dashBoardHelper.clickTransferInTab();
			ExecutionLog.Log("Clicked on Transfers In tab");
									
			//Enter a domain name
			transferHelper.enterDomainName();
			ExecutionLog.Log("Domain name is entered");
									
			// Click on Add Domain button
			transferHelper.clickAddDomain();
			ExecutionLog.Log("Clicked on Add Domain button");
									
			// Verify domain is added
			transferHelper.verifyDomainAdded();
			ExecutionLog.Log("Domain is added");
						
			// Click on Transfer to AppDetext Vault button
			transferHelper.clickTransferToAppDetexVault();
			ExecutionLog.Log("Clicked on Transfer to AppDetext Vault button");
									
			// Click on Initiate The Transfer button
			transferHelper.clickInitateTheTransfer();
			ExecutionLog.Log("Clicked on Initiate The Transfer button");
			
			// Click on Dashboard tab
			dashBoardHelper.clickDashboardTab();
			ExecutionLog.Log("Clicked on Dashboard tab");
						
			// Click on Transfers Tab
			dashBoardHelper.clickTransfersTab();
			ExecutionLog.Log("Clicked on Transfers tab");
						
			// Select Added transfer
			transferHelper.selectAddedTransfer();
			ExecutionLog.Log("Selected the transfer domain");
			
			// Delete the Transfer
			transferHelper.deleteTransfer();
			ExecutionLog.Log("Selected transfer deleted");
			
			//Verified details present on Orders section
			String domain =propertyReader.readApplicationFileForUsers("TransferDomain");
			ordersHelper.verifyOrderDetails(domain, "CUSTOMER_TRANSFER_DELETE", "COMPLETE");
			ExecutionLog.Log("Verified deleted transfer details present on Orders section");	
			
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
