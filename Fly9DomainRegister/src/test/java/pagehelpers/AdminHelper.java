package pagehelpers;

import locators.AdminLocators;
import locators.LoginLocators;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverHelper;
import utils.PropertyReader;

public class AdminHelper extends DriverHelper 
{
	
	public AdminHelper(WebDriver driver) 
	{
		super(driver);		
	}
	PropertyReader propertyReader = new PropertyReader();
	/**
	  * Select Customers link from drop down
	  * @author Varesh
	  */
	public void selectCustomers()
	{
		try
		{
			mouseOver(AdminLocators.HOVERSELLERNAME);
			clickOn(AdminLocators.CUSTOMERS);
		}
		catch(Exception e)
		{
			mouseOver(AdminLocators.HOVERSELLERNAME);
			clickOn(AdminLocators.CUSTOMERS);
		}
	}
	
	/**
	  * Click on New Customer button
	  * @author Varesh
	  */
	public void clickNewCustomerBtn()
	{
		clickOn(AdminLocators.NEWCUSTOMER);
	}
	
	/**
	  * Add new customers details
	  * @author Varesh
	  */
	int random = randomNumber(100000000);
	public void addNewCustomer(String accountName, String name, String email, String phone)
	{
		propertyReader.updateProperty("CustomerName", accountName +random);
		
		sendKeys(AdminLocators.ACCOUNTNAME, accountName +random);
		sendKeys(AdminLocators.NAME, name +random);
		sendKeys(AdminLocators.EMAIL, "test@gmail.");
		type(AdminLocators.EMAIL, "com");
		sendKeys(AdminLocators.ADDRESS, "Test Address");
		sendKeys(AdminLocators.PHONENUMBER, phone);
		clickOn(AdminLocators.ACTIVEICON);
		clickOn(AdminLocators.ACCOUNTMANAGERTAB);
		sendKeys(AdminLocators.ACCOUNTMANAGERNAME, "Test Manager Name");
		sendKeys(AdminLocators.ACCOUNTMANAGEREMAIL, "testmanager@abc.");
		type(AdminLocators.ACCOUNTMANAGEREMAIL, "com");
		sendKeys(AdminLocators.ACCOUNTMANAGERPHONE, "123456789");
		clickOn(AdminLocators.SAVEBTN);
		waitForLoad(2000);
	}
	
	/**
	  * Verify new customer is added
	  * @author Varesh
	  */
	public void verifyNewCustomerAdded(String accountName, String name, String email, String phone)
	{
		int totalCustomers = getTotalRow(AdminLocators.TOTALCUSTOMERS);
		String customerName= getText("//div[contains(@class,'mainSection')]//tbody/tr["+totalCustomers+"]/td[2]");
		String custAccountName= getText("//div[contains(@class,'mainSection')]//tbody/tr["+totalCustomers+"]/td[3]");
		String custStatus= getText("//div[contains(@class,'mainSection')]//tbody/tr["+totalCustomers+"]/td[4]");
		String custEmail= getText("//div[contains(@class,'mainSection')]//tbody/tr["+totalCustomers+"]/td[5]");
		String custPhone= getText("//div[contains(@class,'mainSection')]//tbody/tr["+totalCustomers+"]/td[6]");
		Assert.assertEquals(customerName, name +random);
		Assert.assertEquals(custAccountName, accountName +random);
		Assert.assertEquals(custStatus, "true");
		Assert.assertEquals(custEmail, email);
		Assert.assertEquals(custPhone, "+1 " +phone);
	}

	/**
	  * Select the added customer from drop down
	  * @author Varesh
	  */
	public void selectAddedCustomer()
	{
		String custName =propertyReader.readApplicationFileForUsers("CustomerName");
		selectDropDown(AdminLocators.CUSTOMERSDROPDOWN, custName);
	}
	
	/**
	  * Select Users link from drop down
	  * @author Varesh
	  */
	public void selectUsers()
	{
		try
		{
			mouseOver(AdminLocators.HOVERSELLERNAME);
			clickOn(AdminLocators.USERS);
			waitForLoad(2000);
		}
		catch(Exception e)
		{
			mouseOver(AdminLocators.HOVERSELLERNAME);
			clickOn(AdminLocators.USERS);
			waitForLoad(2000);
		}
	}
	
	/**
	  * Click on New User button
	  * @author Varesh
	  */
	public void clickNewUserBtn()
	{
		try
		{
			clickOn(AdminLocators.NEWUSER);
		}
		
		catch(Exception e)
		{
			clickOn(AdminLocators.NEWUSER);
		}
	}
	
	/**
	  * Add User Details with Customer All Role
	  * @author Varesh
	  */
	public void addUserDetails(String UserPassword)
	{

		propertyReader.updateProperty("Useremail", "user"+random+"@yopmail.com");
		sendKeys(AdminLocators.FIRSTNAME, "first" +random);
		sendKeys(AdminLocators.LASTNAME, "last" +random);
		sendKeys(AdminLocators.USEREMAIL, "user"+random+"@yopmail.");
		type(AdminLocators.USEREMAIL, "com");
		sendKeys(AdminLocators.USERPASSWORD, UserPassword);
		sendKeys(AdminLocators.SCREENANME, "testscreen" +random);
		sendKeys(AdminLocators.CALLINPIN, "123456");
		clickOn(AdminLocators.CUSTOMERALLICON);
		clickOn(AdminLocators.USERSAVE);
		waitForLoad(2000);
		WaitForElementPresent(AdminLocators.SUCCESSMESSAGE, 10);
		WaitForElementNotPresent(AdminLocators.SUCCESSMESSAGE, 10);
	}
	
	/**
	  * Verify New User is created
	  * @author Varesh
	  */
	public void verifyNewUserCreated()
	{
		int totalUsers = getTotalRow(AdminLocators.TOTALUSERS);
		String email= getText("//div[contains(@class,'usersContainer')]/table[2]//tbody/tr["+totalUsers+"]//td[1]");
		String screenName= getText("//div[contains(@class,'usersContainer')]/table[2]//tbody/tr["+totalUsers+"]//td[4]");
		Assert.assertEquals(screenName, "testscreen" +random);
		Assert.assertEquals(email, "user"+random+"@yopmail.com");
		waitForLoad(1000);
	}
	
	/**
	  * Login as created user
	  * @author Varesh
	  */
	public void loginAsUser(String UserPassword)
	{
		String Useremail =propertyReader.readApplicationFileForUsers("Useremail");
		sendKeys("//input[@ng-model='user.email']", Useremail);
		sendKeys(LoginLocators.PASSWORD, UserPassword);
		clickOn("//button[contains(.,'Login')]");
	}
	
	/**
	  * Select the user checkbox
	  * @author Varesh
	  */
	public void selectUserCheckbox()
	{
		String Useremail =propertyReader.readApplicationFileForUsers("Useremail");
		int totalUsers= getTotalRow("//div[contains(@class,'mainSection')]//table[2]//tr");
		for(int i=1; i<=totalUsers; i++)
		{
			String user = getText("//div[contains(@class,'mainSection')]//table[2]//tr["+i+"]//td");
			if(user.contains(Useremail))
			{
				clickOn("//div[contains(@class,'mainSection')]//table[2]//tbody//tr["+i+"]//input[@type='checkbox']");
				waitForLoad(1000);
				break;
			}
		}

	}
	
	/**
	  * Edit the user details
	  * @author Varesh
	  */
	public void editUser(String EditScreenName)
	{
		sendKeys(AdminLocators.EDITSCREENAME, EditScreenName +random);
		clickOn(AdminLocators.EDITUSERSAVE);
		WaitForElementPresent(AdminLocators.SUCCESSMESSAGE, 10);
	}
	
	/**
	  * Verify user details are edited
	  * @author Varesh
	  */
	public void verifyUserDeatilsEdited(String EditScreenName)
	{
		int totalUsers= getTotalRow("//div[contains(@class,'mainSection')]//table[2]//tbody//tr");
		for(int i=1; i<=totalUsers; i++)
		{
			String screenName= getText("//div[contains(@class,'usersContainer')]/table[2]//tbody/tr["+i+"]//td[4]");
			if(screenName.contains(EditScreenName +random))
			{
				Assert.assertEquals(screenName, EditScreenName +random);
				break;
			}
		}
	}
	
	/**
	  * Verify user details are edited
	  * @author Varesh
	  */
	public void enableTwoStepAuthentication()
	{
		clickOn(AdminLocators.TWOSTEPAUTHENTICATION);
		clickOn(AdminLocators.SWITCHONTWOSTEPAUTH);
		selectDropDown(AdminLocators.COUNTRY, "India");
		sendKeys(AdminLocators.TWOSTEPPHONENUMBER, "7503847879");
		clickOn(AdminLocators.TWOSTEPSAVE);
		WaitForElementPresent(AdminLocators.SUCCESSMESSAGE, 10);
		WaitForElementNotPresent(AdminLocators.SUCCESSMESSAGE, 10);
	}
	
	/**
	  * Verify user details are edited
	  * @author Varesh
	  */
	public void verifyTwoStepWindow()
	{
		Assert.assertTrue(isElementPresent(AdminLocators.TWOSTEPWINDOW));
	}
}
