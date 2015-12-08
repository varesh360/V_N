package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class ResetPasswordLocators {
	public final static String RESETPASSWORDLINK = "//a[@class='actionAnchor']";
	public final static String ENTEREMAIL = "//input[@name='forgetPasswordEmail']";
	public final static String RESETPASSWORDBTN = "//div[contains(@class,'authModal')]//button[contains(.,'Reset password')]";
	public final static String MAILLOGIN = "//input[@id='login']";
	public final static String CHECKINBOX = "//input[@type='submit']";
	public final static String CHKFORNEWEMAIL = "//span[@class='slientext']";
	public final static String SUCCESSMESSAGE = "//div[@class='toast-message']";
	public final static String PASSWORDLINK = "//a[@rel='nofollow']";
	public final static String NEWPASSWORD = "//input[@name='plainPassword']";
	public final static String CONFIRMPASSWORD = "//input[@name='confirmPassword']";
	public final static String RESETBTN = "//button[contains(.,'Reset')]";
	public final static String SCREENNAME = "//div[@class='bottomRightNavigation']/div[2]";
	public final static String CHANGEPASSWORD = "//div[@class='bottomRightNavigation']/div[2]//a[contains(.,'Change password')]";
	public final static String OLDPASSWORD = "//input[@name='oldPassword']";
	public final static String ENTERNEWPASSWORD = "//input[@name='newPassword']";
	public final static String ENTERCONFIRMPASSWORD = "//input[@name='confirmPassword']";
	public final static String SAVEPASSWORD = "//form[@id='changePasswordForm']//button[contains(.,'Save')]";
	public final static String CLOSE = "//i[@class='fa fa-times']";
	
}
