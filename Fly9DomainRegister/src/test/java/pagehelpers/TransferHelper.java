package pagehelpers;

import locators.AdminLocators;
import locators.TransfersLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverHelper;
import utils.PropertyReader;

public class TransferHelper extends DriverHelper 
{
	
	public TransferHelper(WebDriver driver) 
	{
		super(driver);		
	}
	PropertyReader propertyReader = new PropertyReader();
	/**
	  * Enter domain name to add
	  * @author Varesh
	  * @param domain 
	  */
	int random = randomNumber(100000000);
	public void enterDomainName()
	{
		propertyReader.updateProperty("TransferDomain", "test" +random +".info");
		sendKeys(TransfersLocators.ENTERDOMAINBOX, "test" +random +".info");
	}
	
	/**
	  * Click on Add domain button
	  * @author Varesh
	  */
	public void clickAddDomain()
	{
		clickOn(TransfersLocators.ADDDOMAIN);
	}
	
	/**
	  * Verify domain is added
	  * @author Varesh
	  */
	public void verifyDomainAdded()
	{
		Assert.assertTrue(isElementPresent(TransfersLocators.DOMAINNAME));
		String getDomain = getText(TransfersLocators.DOMAINNAME);
		Assert.assertEquals(getDomain, "test" +random +".info");
	}
	
	/**
	  * Delete the added domain
	  * @author Varesh
	  */
	public void deleteDomain()
	{
		clickOn(TransfersLocators.DELETEDOMAINBTN);
	}
	
	/**
	  * Verify added domain is deleted
	  * @author Varesh
	  */
	public void verifyAddedDomainDeleted()
	{
		Assert.assertFalse(isElementPresent(TransfersLocators.DOMAINNAME));
	}
		
	/**
	  * Verify Transfers In section is opened with desired columns
	  * @author Varesh
	  */
	public void verifyTransferSection()
	{
		Assert.assertTrue(isElementPresent(TransfersLocators.DOMAINNAMECOLUMN));
		Assert.assertTrue(isElementPresent(TransfersLocators.ADMINEMAILCOLUMN));
		Assert.assertTrue(isElementPresent(TransfersLocators.CURRENTSTATUSCOLUMN));
		Assert.assertTrue(isElementPresent(TransfersLocators.PREVIOUSSTATUSCOLUMN));
	}
	
	/**
	  * Click on Transfert to AppDetext Vault button
	  * @author Varesh
	  */
	public void clickTransferToAppDetexVault()
	{
		clickOn(TransfersLocators.TRANSFERTOAPPDETEXVAULT);
	}
	
	/**
	  * Click on  Initiate Transfer button
	  * @author Varesh
	  */
	public void clickInitateTheTransfer()
	{
		clickOn(TransfersLocators.INITIATETHETRANSFER);
		waitForLoad(2000);
	}
	
	/**
	  * Select the added transfer domain
	  * @author Varesh
	  */
	public void selectAddedTransfer()
	{
		int totalDomains= getTotalRow(TransfersLocators.TOTALTRANSFERDOMAINS);
		for(int i=1; i<=totalDomains; i++)
		{
			String domain = getText("//table[contains(@class,' transfersTable')]/tbody/tr["+i+"]//td[2]");
			System.out.println("test" +random +".info");
			if(domain.contains("test" +random +".info"))
			{
				Assert.assertTrue(isElementPresent("//td[contains(.,'"+"test" +random +".info"+"')]"));
				clickOn("//table[contains(@class,' transfersTable')]/tbody/tr["+i+"]//input");
				break;
			}
		}
	}
	
	/**
	  * Update Auth Code on the domain
	  * @author Varesh
	  */
	public void updateAuthCode()
	{
		waitForLoad(2000);
		clickOn(TransfersLocators.EXPANDAUTHCODE);
		sendKeys(TransfersLocators.ENTERAUTHCODE, "123456");
		clickOn(TransfersLocators.SAVEAUTHCODE);
		WaitForElementPresent(AdminLocators.SUCCESSMESSAGE, 10);
		WaitForElementNotPresent(AdminLocators.SUCCESSMESSAGE, 10);
	}
	
	/**
	  * Delete the transfer domain
	  * @author Varesh
	  */
	public void deleteTransfer()
	{
		int totalDomains= getTotalRow(TransfersLocators.TOTALTRANSFERDOMAINS);
		if(totalDomains>1)
		{
			waitForLoad(3000);
			clickOn("//span[contains(.,'Delete')]");
			waitForLoad(3000);
			clickOn("//button[contains(.,'Delete')]");
			WaitForElementPresent(AdminLocators.SUCCESSMESSAGE, 10);
			WaitForElementNotPresent(AdminLocators.SUCCESSMESSAGE, 10);
			int acttotalDomains= getTotalRow(TransfersLocators.TOTALTRANSFERDOMAINS);
			Assert.assertEquals(acttotalDomains, totalDomains-1);
		}
	}
}
