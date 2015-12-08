package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class DashboardLocators {
	public final static String ACTIVE = "//td[contains(.,'Active')]";
	public final static String SOONEXPIRING = "//td[contains(.,'Soon Expiring')]";
	public final static String INPROGRESS = "//td[contains(.,'In progress')]";
	public final static String DASHBOARDTAB = "//div[contains(text(),'Dashboard')]";
	public final static String ACTIONREQUIRED = "//td[contains(.,'Action Required')]";
	public final static String TRANSFERINTAB = "//div[@ui-sref='transfer']";
	public final static String MESSAGESTAB = "//div[@ui-sref='messages']";
	public final static String MESSAGELINK = "//table[contains(@class,'customTable')]//td";
	public final static String MESSAGESUBJECT = "//div[contains(@class,'modalBody')]//div[2]/h4";
	public final static String CLOSE = "//div[contains(@class,'modalClose')]/i";
	public final static String TRANSFERSTAB = "//div[@ui-sref='transfers']";
	public final static String DOMAINSTAB = "//div[@ui-sref='domains']";
}
