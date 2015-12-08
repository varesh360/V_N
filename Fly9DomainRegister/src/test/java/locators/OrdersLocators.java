package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class OrdersLocators {
	public final static String ORDERSTAB = "//div[@ui-sref='orders']";
	public final static String DOMAINNAME = "//table[@class='orderItemsTable']//td[1]";
	public final static String PRODUCTTYPE = "//table[@class='orderItemsTable']//td[3]";
	public final static String STATUS = "//table[@class='orderItemsTable']//td[4]";
}
