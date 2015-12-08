package locators;

//locator class is public static final which means it can be accessed by all and cannot be changed.

public class SearchDomainLocators {
	public final static String SEARCHDOMAINS = "//div[contains(text(),'Search Domains')]";
	public final static String SEARCHBOX = "//input[@ng-model='domainsSearchQuery']";
	public final static String SEARCHBTN = "//button[contains(text(),'Search')]";
	public final static String TOTALRESULTS = "//div[@id='searchResults']//div//tr[@class='ng-scope']";
}
