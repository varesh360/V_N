package scripts;

import org.testng.annotations.Test;
import pagehelpers.CartHelper;
import pagehelpers.DomainsHelper;
import pagehelpers.LoginHelper;
import pagehelpers.SearchDomainsHelper;
import utils.DriverTestCase;
import utils.ExecutionLog;

/**
 * @author Fly9
 *
 */
public class SearchDomains extends DriverTestCase{

	/**
	 * This test case to add the domain to cart and perform checkout process
	 */
	@Test
	public void testSearchDomainsFunctionality() throws Exception
	{
		try
		{
			// Initialize helper objects
			LoginHelper loginHelper= new LoginHelper(getWebDriver());
			CartHelper cartHelper= new CartHelper(getWebDriver());
			SearchDomainsHelper searchDomainHelper= new SearchDomainsHelper(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			DomainsHelper domainsHelper= new DomainsHelper(getWebDriver());
			
			//String username =propertyReader.readApplicationFileForUsers("Username");
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
			
			// Delete the added domain
			cartHelper.clickDeleteDomain();
			ExecutionLog.Log("Delete the added domain");
			
			// Verify added domain is deleted
			cartHelper.verifyAddedDomainDeleted();
			ExecutionLog.Log("Verified added domain deleted");
						
			// Close the Cart window
			cartHelper.closeCartWindow();
			ExecutionLog.Log("Cart window is closed");
				
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
			
			// Edit Contact
			cartHelper.editContact();
			ExecutionLog.Log("Edit the contact");
			
			// Verify Contact is edited
			cartHelper.verifyContactEdited();
			ExecutionLog.Log("Contact is edited");
			
			// Click on Submit Order button
			cartHelper.clickSubmitOrder();
			ExecutionLog.Log("Clicked on Submit Order button");
			
			// Verify Order is submitted
			cartHelper.verifyOrderSubmitted();
			ExecutionLog.Log("Order is submitted");
			
			// Click on Success Icon
			cartHelper.clickSuccessIcon();
			ExecutionLog.Log("Clicked on Success Icon");
			
			// Verify Domain is present on Domains section
			searchDomainHelper.verifyDomainPresent();
			ExecutionLog.Log("Domain is present on Domains section");
			
			// Click a domain check box
			domainsHelper.selectDomain();
			ExecutionLog.Log("Domain check box is selected");
						
			// Verify Domain is selected
			domainsHelper.verifyDomainIsSelected();
			ExecutionLog.Log("Domain is selected and verified");
						
			// Auto Renew the Domain
			domainsHelper.autoRenewDomain();
			ExecutionLog.Log("Domain Auto Renewed is ON");
						
			// Enable WhoIs privacy
			domainsHelper.enableWhoIsPrivacy();
			ExecutionLog.Log("Enabled WhoIs privacy");
			
			// Disable WhoIs privacy
			domainsHelper.disableWhoIsPrivacy();
			ExecutionLog.Log("Disabled WhoIs privacy");
			
			// Click on Domain Contacts link
			domainsHelper.clickDomainContactsLink();
			ExecutionLog.Log("Clicked on Domain Contacts link");

			// Click on Change Contacts button
			domainsHelper.clickChangeContactsBtn();
			ExecutionLog.Log("Clicked on Change Contacts button");
						
			// Select Multiple Domains
			domainsHelper.selectMultipleDomains();
			ExecutionLog.Log("Select Multiple domains are selected");
						
			// Verify Multiple domains are selected
			domainsHelper.verifyMultipleDomainsSelected();
			ExecutionLog.Log("Multiple domains are selected");
						
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
