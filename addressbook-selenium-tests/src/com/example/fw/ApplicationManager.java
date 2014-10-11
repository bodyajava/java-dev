package com.example.fw;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	public WebDriver driver;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private PrintPhonesHelper printPhonesHelper;
	public final String baseUrl = "http://localhost/";
	
	public ApplicationManager () {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl + "addressbookv4.1.4/");
	}

	public void stop() {
		driver.quit();
	}

	public NavigationHelper navigateTo(){
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		};
		return navigationHelper;
	}

	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		};
		return groupHelper;
	}

	public ContactHelper getContactHelper(){
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		};
		return contactHelper;
	}
	 
	public PrintPhonesHelper getPrintPhonesHelper(){
		if (printPhonesHelper == null) {
			printPhonesHelper = new PrintPhonesHelper(this);
		};
		return printPhonesHelper;
	}

}
