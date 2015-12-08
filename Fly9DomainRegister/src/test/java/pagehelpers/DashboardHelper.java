package pagehelpers;

import locators.DashboardLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverHelper;

public class DashboardHelper extends DriverHelper 
{
	
	public DashboardHelper(WebDriver driver) 
	{
		super(driver);		
	}
	
	/**
	  * Click on Dashboard tab
	  * @author Varesh
	  */
	public void clickDashboardTab()
	{
		WaitForElementPresent(DashboardLocators.DASHBOARDTAB, 10);
		
		try // Click on Search Domains
		{
			clickOn(DashboardLocators.DASHBOARDTAB);
		}
		catch (Exception e) // Try if fails 
		{
			clickOn(DashboardLocators.DASHBOARDTAB);
		}
	}
	
	/**
	  * Verify Domain section with Active and Soon Expiring options are present
	  * @author Varesh
	  */
	public void verifyDomainSection()
	{
		Assert.assertTrue(isElementPresent(DashboardLocators.ACTIVE));
		Assert.assertTrue(isElementPresent(DashboardLocators.SOONEXPIRING));
	}
	
	/**
	  * Verify Transfers section with In Progress and Action Required options are present
	  * @author Varesh
	  */
	public void verifyTransfersSection()
	{
		Assert.assertTrue(isElementPresent(DashboardLocators.INPROGRESS));
		Assert.assertTrue(isElementPresent(DashboardLocators.ACTIONREQUIRED));
	}
	
	/**
	  * Click on Transfers In tab
	  * @author Varesh
	  */
	public void clickTransferInTab()
	{
		WaitForElementPresent(DashboardLocators.TRANSFERINTAB, 10);
		
		try // Click on Transfers In
		{
			clickOn(DashboardLocators.TRANSFERINTAB);
		}
		catch (Exception e) // Try if fails  
		{
			clickOn(DashboardLocators.TRANSFERINTAB);
		}
	}
	
	/**
	  * Click on Messages tab
	  * @author Varesh
	  */
	public void clickMessagesTab()
	{
		WaitForElementPresent(DashboardLocators.MESSAGESTAB, 10);
		
		try // Click on Message
		{
			clickOn(DashboardLocators.MESSAGESTAB);
		}
		catch (Exception e) // Try if fails 
		{
			clickOn(DashboardLocators.MESSAGESTAB);
		}
	}
	
	/**
	  * Click on a message
	  * @author Varesh
	  */
	String message =null;
	public void clickMessageLink()
	{
		WaitForElementPresent(DashboardLocators.MESSAGELINK, 10);
		message =getText(DashboardLocators.MESSAGELINK);
		clickOn(DashboardLocators.MESSAGELINK);
	}
	
	/**
	  * Verify message window is opened
	  * @author Varesh
	  */
	public void verifyMessageWindowOpen()
	{	
		String text = getText("//h4[@class='ng-binding']");
		Assert.assertEquals(text, message);
		clickOn(DashboardLocators.CLOSE);
	}
	
	/**
	  * Click on Transfers tab
	  * @author Varesh
	  */
	public void clickTransfersTab()
	{
		WaitForElementPresent(DashboardLocators.TRANSFERSTAB, 10);
		
		try // Click on Transfers tab
		{
			clickOn(DashboardLocators.TRANSFERSTAB);
		}
		catch (Exception e) // Try if fails 
		{
			clickOn(DashboardLocators.TRANSFERSTAB);
		}
	}

	/**
	  * Click on Domains tab
	  * @author Varesh
	  */
	public void clickDomainsTab()
	{
		WaitForElementPresent(DashboardLocators.DOMAINSTAB, 10);
		
		try // Click on Domains
		{
			clickOn(DashboardLocators.DOMAINSTAB);
		}
		catch (Exception e) // Try if fails  
		{
			clickOn(DashboardLocators.DOMAINSTAB);
		}
	}
	
}
