package pagehelpers;

import locators.CartLocators;
import locators.DomainsLocators;
import locators.SearchDomainLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.DriverHelper;
import utils.PropertyReader;

public class SearchDomainsHelper extends DriverHelper 
{
	
	public SearchDomainsHelper(WebDriver driver) 
	{
		super(driver);		
	}
	PropertyReader propertyReader = new PropertyReader();
	/**
	  * Click on Search Domains tab
	  * @author Varesh
	  */
	public void clickSearchDomains()
	{
		WaitForElementPresent(SearchDomainLocators.SEARCHDOMAINS, 10);
		
		try // Click on Search Domains
		{
			clickOn(SearchDomainLocators.SEARCHDOMAINS);
		}
		catch (Exception e) // If try fails 
		{
			clickOn(SearchDomainLocators.SEARCHDOMAINS);
		}
	}
	
	/**
	  * Enter search for domain
	  * @author Varesh
	  * @param search domain name for search
	  */
	int random = randomNumber(1000000);
	String search = "testdomain" +random +".info";
	public void enterSearch()
	{
		propertyReader.updateProperty("Domain", search);
		sendKeys(SearchDomainLocators.SEARCHBOX, search);
	}
	
	/**
	  * Click on Search button
	  * @author Varesh
	  */
	public void clickSearchBtn()
	{
		clickOn(SearchDomainLocators.SEARCHBTN);
		waitForLoad(2000);
	}
	
	/**
	  * Verify Search results
	  * @author Varesh
	  * @param search domain name used for search
	  */
	public void verifySearchResults()
	{
		WaitForElementPresent(SearchDomainLocators.TOTALRESULTS, 10);
		int totalResults= getTotalRow(SearchDomainLocators.TOTALRESULTS);
		System.out.println("Total Domains are: " +totalResults);
		for(int i=1; i<=totalResults; i++)
		{
			String domainText = getText("//div[@id='searchResults']//div//tr["+i+"]//td");
			if(domainText.contains(search))
			{
				Assert.assertTrue(domainText.contains(search));
				//Assert.assertTrue(isElementPresent("//div[@id='searchResults']//div//tr["+i+"]//td[2]")); // Verify Price is present
				//Assert.assertTrue(isElementPresent("//div[@id='searchResults']//div//tr["+i+"]//td[3]")); // Verify domain available or not icon is present
				break;
			}
			
		}
	}
	
	/**
	  * Add Domain to cart
	  * @author Varesh
	  */
	String domainText= null;
	String price = null;
	public void addDomain()
	{
		// Get total domains
		int totalResults= getTotalRow(CartLocators.TOTALRESULTS);
		// Click on Add button
		for(int i=1; i<=totalResults; i++)
		{
			//Get Domain name and price
			domainText = getText("//div[@id='searchResults']/div//tr["+i+"]//td");
			this.waitForLoad(3000);
			//price = getText("//div[@id='searchResults']//div//tr["+i+"]//td[2]");
			if(domainText.contains(search))
			{
				System.out.println("Clicking on Add Button");
				clickOn("//div[@id='searchResults']//tr["+i+"]//span[@class='ng-scope']");
				waitForLoad(3000);
				break;
			}
		}
	}
	
	/**
	  * Verify Domain is added to cart
	  * @author Varesh
	  */
	public void verifyDomainAdded()
	{		
		String getAddedDomainName= getText(CartLocators.GETADDEDDOMAINNAME);
		//String getAddedDomainPrice= getText(CartLocators.GETADDEDDOMAINPRICE);
		Assert.assertEquals(getAddedDomainName, domainText);
		//Assert.assertEquals(getAddedDomainPrice, price);
	}
	
	/**
	  * Verify domain is present
	  * @author Varesh
	  */
	public void verifyDomainPresent()
	{
		String domain = getText(DomainsLocators.DOMAINNAME);
		Assert.assertEquals(domain, search);
	}
}
