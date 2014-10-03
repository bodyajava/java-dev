package com.example.fw;

import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;	
	
	public HelperBase(ApplicationManager manager){
		this.manager = manager;
		this.driver = manager.driver;
	}
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	acceptNextAlert = true;
	    }
	  }
	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);	
		}
	}
	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null) {
			new Select(driver.findElement(locator)).selectByVisibleText(text);	
		}
	}
		
	public void selectDropDownItemByRandom(String locator) {
		Select selectBox = new Select(driver.findElement(By.name(locator)));
	    int selectOptions = selectBox.getOptions().size();
	    Random rnd = new Random();
	    selectBox.selectByIndex(rnd.nextInt(selectOptions - 1));
	}

	public int generateIndexBasedOnListSize(int listSize) {
		Random rnd = new Random();
		int index = rnd.nextInt(listSize - 1);
		return index;
	}

}
