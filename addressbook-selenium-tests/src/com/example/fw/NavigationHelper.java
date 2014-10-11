package com.example.fw;

import org.openqa.selenium.By;
import com.example.fw.ApplicationManager;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void storefront() {
		manager.driver.get(manager.baseUrl + "addressbookv4.1.4/");
	}

	public void mainPage() {
		//if (! onMainPage()) {
			click(By.linkText("home"));
		//}
	}

	public void groupsPage() {
		//if (! onGroupsPage()) {
			click(By.linkText("groups"));
		//}
	}

	public void printPhonesPage() {
		//if (! onGroupsPage()) {
			click(By.linkText("print phones"));
		//}
	}

	/*
	private boolean onMainPage() {
		return isElementExist(By.id("maintable"));
		//return ! driver.findElements(By.id("maintable")).isEmpty();
	}

	private boolean onGroupsPage() {
		boolean url = driver.getCurrentUrl().contains("/group.php");
		//boolean button = driver.findElements(By.name("new")).size() > 0; 
		
		if (url && isElementExist(By.name("new"))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean isElementExist(By locator) {
		boolean exists = false;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	    try {
	    	driver.findElement(locator);
	    	exists = true;
	    } catch (NoSuchElementException e) {
	    	
	    }
	    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	    return exists;
	}
	*/
	
}
