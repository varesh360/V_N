package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class FooterLocators {
	public final static String WHOISSEARCHLINK = "//a[contains(.,'Whois Search')]";
	public final static String ENTERSEARCH = "//input[@ng-model='searchModel']";
	public final static String CLICKSEARCHBTN = "//button[contains(.,'Search')]";
	public final static String GETSEARCHDATA = "//pre[@class='ng-binding']";
	public final static String LEGALLINK = "//a[contains(.,'Legal')]";
	public final static String CLOSE = "//div[@class='modalContainer']//i";
	
}
