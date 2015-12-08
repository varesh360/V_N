package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class TransfersLocators {
	public final static String TRANSFERTOAPPDETEXVAULT = "//button[contains(.,'Transfer to AppDetex VAULT')]";
	public final static String INITIATETHETRANSFER = "//button[contains(.,'Initiate the transfer')]";
	public final static String ENTERDOMAINBOX = "//section[@class='search row']//textarea";
	public final static String ADDDOMAIN = "//button[contains(.,'Add Domain')]";
	public final static String DOMAINNAME = "//div[contains(@class,'fullDomainName')]";
	public final static String DELETEDOMAINBTN = "//i[@class='closeBtn']";
	public final static String DOMAINNAMECOLUMN = "//th[contains(.,'Domain name')]";
	public final static String ADMINEMAILCOLUMN = "//th[contains(.,'Admin Email')]";
	public final static String CURRENTSTATUSCOLUMN = "//th[contains(.,'Current Status')]";
	public final static String PREVIOUSSTATUSCOLUMN = "//th[contains(.,'Previous Status')]";
	
	public final static String SELECTTRANSFER = "//input[@ng-checked='transfer._selected']";
	public final static String EXPANDAUTHCODE = "//span[contains(.,'Auth Code')]";
	public final static String ENTERAUTHCODE = "//input[@id='authCodeForm']";
	public final static String SAVEAUTHCODE = "//button[contains(.,'Save')]";
	public final static String TOTALTRANSFERDOMAINS = "//table[contains(@class,' transfersTable')]/tbody/tr";
}
