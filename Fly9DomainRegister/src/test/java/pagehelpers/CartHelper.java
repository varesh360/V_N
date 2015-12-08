package pagehelpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import locators.CartLocators;
import utils.DriverHelper;

public class CartHelper extends DriverHelper 
{
	
	public CartHelper(WebDriver driver) 
	{
		super(driver);		
	}
		
	/**
	  * Click on Cart Icon
	  * @author Varesh
	  */
	public void clickCartIcon()
	{
		clickOn(CartLocators.CARTICON);
	}
	
	/**
	  * Click on Delete Icon
	  * @author Varesh
	  */
	public void clickDeleteDomain()
	{
		clickOn(CartLocators.DELETEICON);
	}
	
	/**
	  * Verify added domain is deleted
	  * @author Varesh
	  */
	public void verifyAddedDomainDeleted()
	{
		Assert.assertTrue(isElementPresent(CartLocators.VALIDATIONTEXT));
	}
	
	/**
	  * Close Cart window
	  * @author Varesh
	  */
	public void closeCartWindow()
	{
		clickOn(CartLocators.CLOSEICON);
		waitForLoad(2000);
	}
	
	/**
	  * Click on Proceed button
	  * @author Varesh
	  */
	public void clickProceed()
	{
		clickOn(CartLocators.PROCEEDBTN);
		waitForLoad(2000);
	}
	
	/**
	  * Verify Trademarks section is opened
	  * @author Varesh
	  */
	public void verifyTrademarksSectionDisplay()
	{
		WaitForElementPresent(CartLocators.TRADEMARKTEXT, 10);
		Assert.assertTrue(isElementPresent(CartLocators.TRADEMARKTEXT));
	}
	
	/**
	  * Verify checkout section is opened
	  * @author Varesh
	  */
	public void verifyCheckoutSectionDisplay()
	{
		WaitForElementPresent(CartLocators.EDITICON, 10);
		Assert.assertTrue(isElementPresent(CartLocators.EDITICON));
	}
	
	/**
	  * Edit Contact
	  * @author Varesh
	  */
	public void editContact()
	{
		clickOn(CartLocators.EDITICON);
		sendKeys(CartLocators.STATEBOX, "Columbia");
		clickOn(CartLocators.SAVEBTN);
		waitForLoad(2000);
	}
	
	/**
	  * Verify contact is edited
	  * @author Varesh
	  */
	public void verifyContactEdited()
	{
		String city= getText(CartLocators.GETEDITEDTEXT);
		Assert.assertEquals(city, "Columbia");
	}
	
	/**
	  * Click on Submit Order button
	  * @author Varesh
	  */
	public void clickSubmitOrder()
	{
		clickOn(CartLocators.SUBMITORDER);
	}
	
	/**
	  * Verify order is submitted
	  * @author Varesh
	  */
	public void verifyOrderSubmitted()
	{
		WaitForElementPresent(CartLocators.SUCCESSSIGN, 10);
		Assert.assertTrue(isElementPresent(CartLocators.VERIFYORDERPLACED));
		Assert.assertTrue(isElementPresent(CartLocators.SUCCESSSIGN));
	}
	
	/**
	  * Click on Succes Icon
	  * @author Varesh
	  */
	public void clickSuccessIcon()
	{
		clickOn(CartLocators.SUCCESSSIGN);
	}
}
