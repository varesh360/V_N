package scripts;

import org.testng.annotations.Test;
import pagehelpers.FooterHelper;
import pagehelpers.LoginHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class WhoISSearchAndLegalLinks extends DriverTestCase{

	/**
	 * This test case is to check the WhoIs Search and Legal link from the footer section
	 */
	@Test
	public void testWhoISSearchAndLegalLinks() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			//CartHelper cartHelper= new CartHelper(getWebDriver());
			//SearchDomainsHelper searchDomainHelper= new SearchDomainsHelper(getWebDriver());
			FooterHelper footerHelper= new FooterHelper(getWebDriver());
			//DomainsHelper domainsHelper= new DomainsHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
			// Open the application
			getWebDriver().navigate().to(URL);
			ExecutionLog.Log("Open the application");
			
			// Login to app
			loginHelper.loginToApp(Email, Password);
			ExecutionLog.Log("User login into application");
			
//			// Click on Search Domains tab
//			searchDomainHelper.clickSearchDomains();
//			ExecutionLog.Log("Clicked on Searched domain tab");
//						
//			// Enter domain name
//			searchDomainHelper.enterSearch();
//			ExecutionLog.Log("Domain name entered");
//						
//			// Click on Search button
//			searchDomainHelper.clickSearchBtn();
//			ExecutionLog.Log("Clicked on Search button");
//						
//			// Verify domains are displayed according to search criteria
//			searchDomainHelper.verifySearchResults();
//			ExecutionLog.Log("Verifed domains are displayed according to search criteria");
//						
//			// Click on Add button on a Domain
//			searchDomainHelper.addDomain();
//			ExecutionLog.Log("Clicked on Add button");
//			
//			// Click on Cart Icon
//			cartHelper.clickCartIcon();
//			ExecutionLog.Log("Clicked on Cart Icon");
//			
//			// Verify Domain is added to Cart
//			searchDomainHelper.verifyDomainAdded();
//			ExecutionLog.Log("Domain is successfully added to cart");
//			
//			// Click on Proceed button
//			cartHelper.clickProceed();
//			ExecutionLog.Log("Clicked on Procedd button");
//			
//			// Verify Checkout section is displayed
//			cartHelper.verifyCheckoutSectionDisplay();
//			ExecutionLog.Log("User is on checkout section");
//			
//			// Click on Submit Order button
//			cartHelper.clickSubmitOrder();
//			ExecutionLog.Log("Clicked on Submit Order button");
//			
//			// Verify Order is submitted
//			cartHelper.verifyOrderSubmitted();
//			ExecutionLog.Log("Order is submitted");
//			
//			// Click on Success Icon
//			cartHelper.clickSuccessIcon();
//			ExecutionLog.Log("Clicked on Success Icon");
//			
//			// Verify Domain is present on Domains section
//			searchDomainHelper.verifyDomainPresent();
//			ExecutionLog.Log("Domain is present on Domains section");
//			
//			// Perform WhoIs search without enabling the WhoIs Privacy
//			footerHelper.whoISSearchWithDisableWhoIsPrivacy();
//			ExecutionLog.Log("Performed WhoIs search without enabling the WhoIs Privacy");
//			
//			// Click a domain check box
//			domainsHelper.selectDomain();
//			ExecutionLog.Log("Domain check box is selected");
//				
//			// Enable WhoIs privacy
//			domainsHelper.enableWhoIsPrivacy();
//			ExecutionLog.Log("Enabled WhoIs privacy");
//			
//			// Perform WhoIs search with enabling the WhoIs Privacy
//			footerHelper.whoISSearchWithEnableWhoIsPrivacy();
//			ExecutionLog.Log("Performed WhoIs search on enabling the WhoIs Privacy");
			
			// Verify the Legal link is working
			footerHelper.verifyLegalLink();
			ExecutionLog.Log("Legal link is working");
						
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
