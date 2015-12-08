package pagehelpers;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import locators.DomainsLocators;
import locators.FooterLocators;
import utils.DriverHelper;

public class FooterHelper extends DriverHelper 
{
	
	public FooterHelper(WebDriver driver) 
	{
		super(driver);		
	}
		
	/**
	  * Perform WhoIs search without enabling the WhoIs Privacy
	  * @author Varesh
	  */
	public void whoISSearchWithDisableWhoIsPrivacy()
	{
		String domain = getText(DomainsLocators.DOMAINNAME);
		clickOn(FooterLocators.WHOISSEARCHLINK);
		sendKeys(FooterLocators.ENTERSEARCH, domain);
		clickOn(FooterLocators.CLICKSEARCHBTN);
		waitForLoad(3000);
		String searchContent= getText(FooterLocators.GETSEARCHDATA);
		Assert.assertTrue(searchContent.contains("Domain Name: "+domain+""));
		Assert.assertTrue(searchContent.contains("Registrant Name: Lawfirm Ravi R5 Lawfirm Surya"));
		Assert.assertTrue(searchContent.contains("Registrant Email: ravi@fly9.com"));
		clickOn(FooterLocators.CLOSE);
	}
	
	/**
	  * Perform WhoIs search with enabling the WhoIs Privacy
	  * @author Varesh
	  */
	public void whoISSearchWithEnableWhoIsPrivacy()
	{
		String domain = getText(DomainsLocators.DOMAINNAME);
		waitForLoad(60000);
		clickOn(FooterLocators.WHOISSEARCHLINK);
		sendKeys(FooterLocators.ENTERSEARCH, domain);
		clickOn(FooterLocators.CLICKSEARCHBTN);
		waitForLoad(3000);
		String searchContent= getText(FooterLocators.GETSEARCHDATA);
		Assert.assertTrue(searchContent.contains("Domain Name: "+domain+""));
		Assert.assertTrue(searchContent.contains("Registrant Name: Private Whois"));
		clickOn(FooterLocators.CLOSE);
	}
	
	/**
	  * Verify Legal link is working
	  * @author Varesh
	  */
	public void verifyLegalLink()
	{
		clickOn(FooterLocators.LEGALLINK);
		 //Focus on the new window opened
	   	  Set<String> windows = getWebDriver().getWindowHandles();
	   	  String child = null;
	   	  Iterator<String> it = windows.iterator();
	   	   while(it.hasNext())
	   	   {
	   	       child = (String) it.next();
	   	   }
	   	  getWebDriver().switchTo().window(child);
	   	  waitForLoad(5000);
	   	  Assert.assertEquals(getWebDriver().getTitle(), "Terms of Service");
	   	  getWebDriver().close();
	}
}
