package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	private WebDriver driver;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private PrintPhonesHelper printPhonesHelper;
	private HibernateHelper hibernateHelper;
	private Properties properties;
	public String baseUrl;
	
	public ApplicationManager (Properties properties) {
	    this.properties = properties;
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

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		};
		return hibernateHelper;
	}

	public WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		if (driver == null) {
		    if (browser.equals("firefox")) {
		    	driver = new FirefoxDriver();	    	
		    } else if (browser.equals("ie")) {
		    	driver = new InternetExplorerDriver();	    	
		    } else if (browser.equals("chrome")) {
		    	driver = new ChromeDriver();	    	
		    } else {
		    	throw new Error("Unsupported browser: '" + browser + "'.");
		    }
		    
		    baseUrl = properties.getProperty("baseUrl");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get(baseUrl);
		};
		return driver;
	}
	
	
}
