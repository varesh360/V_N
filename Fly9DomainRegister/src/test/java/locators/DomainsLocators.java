package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class DomainsLocators {
	public final static String RENEWLINK = "//div[contains(@class,'transcludedContent')]/div[2]//span";
	public final static String AUTORENEWALBTN = "//div[contains(@class,'switchContainer')]/div";
	public final static String ONEYEARBTN = "//button[contains(.,'1 Year')]";
	public final static String THREEYEARBTN = "//button[contains(.,'3 Year')]";
	public final static String FIVEYEARBTN = "//button[contains(.,'5 Year')]";
	public final static String WHOISPRIVACY = "//span[contains(.,'WhoIs Privacy')]";
	public final static String DISABLEWHOISPRIVACY = "//button[contains(.,'Disable WhoIs Privacy')]";
	public final static String ONEYEARPRIVACYBTN = "//div[contains(@class,'transcludedContent')]/div[9]//button[contains(.,'1 Years')]";
	public final static String PRIVACYENABLED = "//table[@class='customTable']//td[6]//i[contains(@class,'text-success')]";
	public final static String PRIVACYDISABLED = "//table[@class='customTable']//td[6]//i[contains(@class,'text-danger')]";
	public final static String DOMAINCONTACTS = "//div[contains(@class,'transcludedContent')]/div[7]//span";
	public final static String SUCCESSMESSAGE = "//div[@class='toast-title']";
	public final static String CHANGECONTACTS = "//button[contains(.,'Change Contacts')]";
	public final static String CURRENTCONTACTSWINDOW = "//h4[contains(.,'Current contacts')]";
	public final static String CANCEL = "//button[contains(.,'Cancel')]";
	public final static String SELECTDOMAIN = "//div[contains(@class,'domainsContainer')]//tbody/tr[1]//input";
	public final static String SELECTSECONDDOMAIN = "//div[contains(@class,'domainsContainer')]//tbody/tr[1]//input";
	public final static String AUTORENEWALENABLED = "//table[@class='customTable']//td[5]//i[contains(@class,'text-success')]";
	public final static String SEARCH = "//input[@placeholder='Search']";
	public final static String LOCKUNLOCKDOMAIN = "//span[contains(.,'Lock / Unlock Domain')]";
	public final static String SWITCHOFFDOMAIN = "//div[contains(@class,'panel-default panel-open')]//div[@class='switchContainer']";
	public final static String DOMAINLOCKED = "//table[@class='customTable']//td[4]//i[contains(@class,'fa-unlock text-danger')]";
	
	public final static String DOMAINNAME = "//div[contains(@class,'domainsContainer')]//td[2]";
	public final static String GETSELECTEDOMAIN = "//div[contains(@class,'transcludedContent')]/div[1]//span";
	
}
