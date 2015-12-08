package pagehelpers;

import locators.DomainsLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverHelper;

public class DomainsHelper extends DriverHelper 
{
	
	public DomainsHelper(WebDriver driver) 
	{
		super(driver);		
	}
	
	
	/**
	  * Select a domain checkbox
	  * @author Varesh
	  */
	public void selectDomain()
	{
		clickOn(DomainsLocators.SELECTDOMAIN);
		waitForLoad(3000);
	}
	
	/**
	  * Verify domain is selected
	  * @author Varesh
	  */
	public void verifyDomainIsSelected()
	{
		String domainName = getText(DomainsLocators.DOMAINNAME);
		String getSelectedDomainName = getText(DomainsLocators.GETSELECTEDOMAIN);
		Assert.assertEquals(getSelectedDomainName, domainName);
	}
	
	/**
	  * Click on Renew link and validated the buttons
	  * @author Varesh
	  */
	public void autoRenewDomain()
	{
		clickOn(DomainsLocators.RENEWLINK);
		clickOn(DomainsLocators.AUTORENEWALBTN);
		Assert.assertTrue(isElementPresent(DomainsLocators.AUTORENEWALENABLED));

	}
	
	/**
	  * Click on Renew link and validated the buttons
	  * @author Varesh
	  */
	public void verifyLockUnclockDmain()
	{
		clickOn(DomainsLocators.RENEWLINK);
		clickOn(DomainsLocators.AUTORENEWALBTN);
		Assert.assertTrue(isElementPresent(DomainsLocators.AUTORENEWALENABLED));

	}
	
	/**
	  * Verify WhoIs Privacy link
	  * @author Varesh
	  */
	public void enableWhoIsPrivacy()
	{
		clickOn(DomainsLocators.WHOISPRIVACY);
		waitForLoad(3000);
		clickOn(DomainsLocators.ONEYEARPRIVACYBTN);
		WaitForElementPresent(DomainsLocators.SUCCESSMESSAGE, 10);
		WaitForElementNotPresent(DomainsLocators.SUCCESSMESSAGE, 10);
		Assert.assertTrue(isElementPresent(DomainsLocators.PRIVACYENABLED));
	}
	
	/**
	  * Verify WhoIs Privacy link
	  * @author Varesh
	  */
	public void disableWhoIsPrivacy()
	{
		clickOn(DomainsLocators.DISABLEWHOISPRIVACY);
		WaitForElementPresent(DomainsLocators.SUCCESSMESSAGE, 10);
		Assert.assertTrue(isElementPresent(DomainsLocators.PRIVACYDISABLED));
	}
	

	/**
	  * Click on Domain Contacts link
	  * @author Varesh
	  */
	public void clickDomainContactsLink()
	{
		clickOn(DomainsLocators.DOMAINCONTACTS);
		waitForLoad(2000);
		Assert.assertTrue(isElementPresent(DomainsLocators.CHANGECONTACTS));
	}
	
	/**
	  * Click on Change Contacts button
	  * @author Varesh
	  */
	public void clickChangeContactsBtn()
	{
		clickOn(DomainsLocators.CHANGECONTACTS);
		Assert.assertTrue(isElementPresent(DomainsLocators.CURRENTCONTACTSWINDOW));
		clickOn(DomainsLocators.CANCEL);
	}
	
	/**
	  * Select Multiple domains
	  * @author Varesh
	  */
	public void selectMultipleDomains()
	{
		getWebDriver().findElement(ByLocator(DomainsLocators.SEARCH)).clear();
		waitForLoad(3000);
		clickOn(DomainsLocators.SELECTSECONDDOMAIN);	
	}
	
	/**
	  * Verify multiple domains are selected
	  * @author Varesh
	  */
	public void verifyMultipleDomainsSelected()
	{
		String getSelectedDomainName = getText(DomainsLocators.GETSELECTEDOMAIN);
		Assert.assertEquals(getSelectedDomainName, "Multiple domains");
	}
}
