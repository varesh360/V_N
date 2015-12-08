package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class AdminLocators {
	public final static String HOVERSELLERNAME = "//div[contains(@class,'ng-scope dropdown')]//span";
	public final static String CUSTOMERS = "//div[contains(@class,'navItem')]//a[contains(.,'Customers')]";
	public final static String NEWCUSTOMER = "//button[contains(.,'New customer')]";
	public final static String ACCOUNTNAME = "//input[@name='orgName']";
	public final static String NAME = "//div[@class='modalBody']//input[@name='orgContactName']";
	public final static String EMAIL = "//input[@ng-model='mycustomer.orgDetails.organizationMainContactEmail']";
	public final static String ADDRESS = "//div[@class='modalBody']//textarea[@name='orgAddress']";
	public final static String PHONENUMBER = "//div[@class='modalBody']//input[@placeholder='Phone Number']";
	public final static String ACTIVEICON = "//div[@class='modalBody']//div[@class='switchContainer']";
	public final static String ACCOUNTMANAGERNAME = "//div[@class='modalBody']//input[@name='accountManagerName']";
	public final static String ACCOUNTMANAGEREMAIL = "//div[@class='modalBody']//input[@name='accountManagerEmail']";
	public final static String ACCOUNTMANAGERPHONE = "//div[@class='modalBody']//input[@name='accountManagerPhone']";
	public final static String SAVEBTN = "//div[@class='modalBody']//button[contains(.,'Save')]";
	public final static String ACCOUNTMANAGERTAB = "//div[@class='modalBody']//div[contains(text(),'Account manager')]";
	public final static String TOTALCUSTOMERS = "//div[contains(@class,'mainSection')]//tbody/tr";
	public final static String CUSTOMERSDROPDOWN = "//div[@class='bottomRightNavigation']//select[@id='globalClients']";
	public final static String USERS = "//div[contains(@class,'navItem')]//a[contains(.,'Users')]";
	
	public final static String NEWUSER = "//button[contains(.,'New user')]";
	public final static String USERNAME = "//input[@placeholder='User name']";
	public final static String FIRSTNAME = "//div[@class='modalBody']//input[@name='firstName']";
	public final static String LASTNAME = "//div[@class='modalBody']//input[@name='lastName']";
	public final static String USEREMAIL = "//div[@class='modalBody']//input[@name='email']";
	
	public final static String USERPASSWORD = "//input[@name='plainPassword']";
	public final static String CUSTOMERALLICON = "//div[@class='modalBody']//div[@class='switchContainer']";
	public final static String CUSTOMERREADICON = "//*[@id='accInfoForm']/div[3]/adx-switch[2]/div/label//div";
	public final static String USERSAVE = "//button[contains(@ng-click,'event)')]";
	public final static String SCREENANME = "//div[@class='modalBody']//input[@name='screenName']";
	public final static String CALLINPIN = "//input[@name='callInPin']";
	public final static String TOTALUSERS = "//div[contains(@class,'usersContainer')]/table[2]//tbody/tr";
	public final static String SELECTUSER = "//div[contains(@class,'usersContainer')]/table[2]//tbody/tr//input";
	
	public final static String EDITFIRSTNAME = "//input[@name='firstName']";
	public final static String EDITLASTNAME = "//input[@name='lastName']";
	public final static String EDITUSEREMAIL = "//input[@name='email']";
	public final static String EDITSCREENAME = "//input[@name='screenName']";
	public final static String EDITUSERSAVE = "//div[@class='panel-group']//button[contains(.,'Save')]";
	public final static String SUCCESSMESSAGE = "//div[@class='toast-message']";
	public final static String TWOSTEPAUTHENTICATION = "//span[contains(.,'Two step authentication.')]";
	public final static String SWITCHONTWOSTEPAUTH = "//div[contains(@class,'transcludedContent')]//div[4]//div[@class='switchContainer']";
	public final static String COUNTRY = "//div[contains(@class,'transcludedContent')]//div[4]//select[contains(@ng-model,'verificationDefaultCountryCode')]";
	public final static String TWOSTEPPHONENUMBER = "//input[@placeholder='Phone Number']";
	public final static String TWOSTEPSAVE = "//div[contains(@class,'transcludedContent')]//div[4]//button[contains(.,'Save')]";
	public final static String TWOSTEPWINDOW = "//h3[contains(.,'2 STEP VERIFICATION')]";
}
