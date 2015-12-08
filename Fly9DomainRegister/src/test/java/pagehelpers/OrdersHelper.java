package pagehelpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import locators.OrdersLocators;
import utils.DriverHelper;

public class OrdersHelper extends DriverHelper 
{
	
	public OrdersHelper(WebDriver driver) 
	{
		super(driver);		
	}
		
	/**
	  * Verify Order Detail section
	  * @author Varesh
	  */
	public void verifyOrderDetails(String domainName, String product, String status)
	{
		//Click on Orders tab
		try
		{
			clickOn(OrdersLocators.ORDERSTAB);
		}
		
		catch(Exception e)
		{
			clickOn(OrdersLocators.ORDERSTAB);
		}
		
		int count = getTotalRow("//table[@class='customTable table']//tbody");
		for(int i=1; i<=count; i++)
		{
			String domain = getText("//table[@class='customTable table']//tbody["+i+"]//tr[2]//td//td[1]");
			if(domain.contains(domainName))
			{
				domain = getText("//table[@class='customTable table']//tbody["+i+"]//tr[2]//td//td[1]");
				String productType = getText("//table[@class='customTable table']//tbody["+i+"]//tr[2]//td//td[3]");
				String domainStatus = getText("//table[@class='customTable table']//tbody["+i+"]//tr[2]//td//td[4]");
		
				Assert.assertEquals(domain, domainName);
				Assert.assertEquals(productType, product);
				Assert.assertEquals(domainStatus, status);
				break;
			}
		}	
	}
}
