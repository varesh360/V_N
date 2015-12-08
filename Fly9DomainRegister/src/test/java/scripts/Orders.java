package scripts;

import org.testng.annotations.Test;
import pagehelpers.CartHelper;
import pagehelpers.DashboardHelper;
import pagehelpers.LoginHelper;
import pagehelpers.OrdersHelper;
import pagehelpers.SearchDomainsHelper;
import pagehelpers.TransferHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class Orders extends DriverTestCase{

	/**
	 * This test case is to verify details of Domain on Orders section
	 */
	@Test
	public void testOrdersSectionForDomains() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			CartHelper cartHelper= new CartHelper(getWebDriver());
			SearchDomainsHelper searchDomainHelper= new SearchDomainsHelper(getWebDriver());
			OrdersHelper ordersHelper= new OrdersHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Enter the email
			loginHelper.loginToApp(Email, Password);
			ExecutionLog.Log("Entered the email");
			
			// Click on Search Domains tab
			searchDomainHelper.clickSearchDomains();
			ExecutionLog.Log("Clicked on Searched domain tab");
						
			// Enter domain name
			searchDomainHelper.enterSearch();
			ExecutionLog.Log("Domain name entered");
						
			// Click on Search button
			searchDomainHelper.clickSearchBtn();
			ExecutionLog.Log("Clicked on Search button");
						
			// Verify domains are displayed according to search criteria
			searchDomainHelper.verifySearchResults();
			ExecutionLog.Log("Verifed domains are displayed according to search criteria");
						
			// Click on Add button on a Domain
			searchDomainHelper.addDomain();
			ExecutionLog.Log("Clicked on Add button");
			
			// Click on Cart Icon
			cartHelper.clickCartIcon();
			ExecutionLog.Log("Clicked on Cart Icon");
			
			// Verify Domain is added to Cart
			searchDomainHelper.verifyDomainAdded();
			ExecutionLog.Log("Domain is successfully added to cart");
			
			// Click on Proceed button
			cartHelper.clickProceed();
			ExecutionLog.Log("Clicked on Procedd button");
			
			// Verify Checkout section is displayed
			cartHelper.verifyCheckoutSectionDisplay();
			ExecutionLog.Log("User is on checkout section");
			
			// Click on Submit Order button
			cartHelper.clickSubmitOrder();
			ExecutionLog.Log("Clicked on Submit Order button");
			
			// Verify Order is submitted
			cartHelper.verifyOrderSubmitted();
			ExecutionLog.Log("Order is submitted");
			
			// Click on Success Icon
			cartHelper.clickSuccessIcon();
			ExecutionLog.Log("Clicked on Success Icon");
			
			//Verified details present on Orders section
			String domain =propertyReader.readApplicationFileForUsers("Domain");
			ordersHelper.verifyOrderDetails(domain, "DOMAIN_REGISTRATION", "COMPLETE");
			ExecutionLog.Log("Verified details present on Orders section");		
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
	 * This test case is to verify details of Transfer Domains on Orders section
	 */
	@Test
	public void testOrdersSectionForTransfers() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			DashboardHelper dashBoardHelper= new DashboardHelper(getWebDriver());
			TransferHelper transferHelper= new TransferHelper(getWebDriver());
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
			
			// Verify details present on Orders section
			String domain =propertyReader.readApplicationFileForUsers("TransferDomain");
			ordersHelper.verifyOrderDetails(domain, "DOMAIN_TRANSFER", "COMPLETE");
			ExecutionLog.Log("Verified details present on Orders section");
						
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
