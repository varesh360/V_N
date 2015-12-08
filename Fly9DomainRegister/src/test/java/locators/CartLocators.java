package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class CartLocators {
	public final static String CARTCOUNT = "//span[contains(@class,'cartItems')]";
	public final static String CARTICON = "//div[contains(@class,'headerActions')]//span[@class='text']";
	public final static String PROCEEDBTN = "//button[@class='extendedButton']";
	public final static String TOTALRESULTS = "//div[@id='searchResults']//div//tr[@class='ng-scope']";
	public final static String GETADDEDDOMAINNAME = "//table[contains(@class,'reviewTable')]//tbody//tr/td";
	public final static String GETADDEDDOMAINPRICE = "//table[contains(@class,'reviewTable')]//tbody//tr/td[4]";
	public final static String DELETEICON = "//i[contains(@class,'fa fa-remove')]";
	public final static String VALIDATIONTEXT = "//div[@class='alert alert-danger']";
	public final static String CLOSEICON = "//div[contains(@class,'modalClose')]/i";
	public final static String TRADEMARKTEXT = "//h3[contains(.,'Trademark Check Warning')]";
	public final static String EDITICON = "//i[contains(@class,'editIcon')]";
	public final static String STATEBOX = "//input[@name='city']";
	public final static String SAVEBTN = "//button[contains(.,'Save')]";
	public final static String GETEDITEDTEXT = "//div[@id='checkoutCheckout']//dl/dd[10]";
	public final static String BACKBTN = "//button[contains(.,'Back')]";
	public final static String SUBMITORDER = "//button[contains(.,'Submit Order')]";
	public final static String VERIFYORDERPLACED = "//h2[contains(.,'Thank you for placing an order')]";
	public final static String SUCCESSSIGN = "//i[@ng-switch-when='SUCCESS']";
}
