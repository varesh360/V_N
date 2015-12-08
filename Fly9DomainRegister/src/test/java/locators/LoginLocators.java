package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class LoginLocators {
	public final static String LOGIN = "//button[@type='submit']";
	public final static String EMAIL = "//input[@name='email']";
	public final static String PASSWORD = "//input[@name='pass']";
	public final static String LOGOUT = "//div[contains(@class,'headerActions')]//a[contains(.,'LOGOUT')]";
}
