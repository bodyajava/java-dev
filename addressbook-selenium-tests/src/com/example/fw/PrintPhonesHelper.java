package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class PrintPhonesHelper extends WebDriverHelperBase {
	
	public PrintPhonesHelper(ApplicationManager manager) {
		super(manager);
	}

	public SortedListOf<String> getPrintedList() {
		manager.navigateTo().printPhonesPage();
		
		SortedListOf<String> printedContacts = new SortedListOf<String>();
		List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
		int index = rows.size();
		
		for (int i = 1; i < index + 1; i++) {
			
			for (int x = 1; x < 4; x++) {
				String cell = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr["+i+"]/td["+x+"]")).getText();
				if (cell.contains(":")) {					
					printedContacts.add(cell);				
				}
			}
		}
		manager.navigateTo().storefront();
		return printedContacts;
	}

	public SortedListOf<String> getProcessedList(SortedListOf<ContactData> databaseList) {
		SortedListOf<String> contactsWithPhones = new SortedListOf<String>();
		
		for (ContactData data : databaseList) {
			String firstname = data.getFirstname();
			String lastname = data.getLastname();
			String phone_home = data.getPhone_home();
			String phone_mobile = data.getPhone_mobile();
			String phone_work = data.getPhone_work();
			String byday = data.getByday();
			String bymonth = data.getBymonth();
			String byyear = data.getByyear();
			String phone2 = data.getPhone2();
			String record = null;
			
			if ((firstname.isEmpty()) && (lastname.isEmpty())) {
				record = ":";
			} else if (firstname.isEmpty()) {
				record = lastname + ":";
			} else {
				record = firstname + " " + lastname + ":";
			}
			
			if (! phone_home.isEmpty()) {
				record = record + "\n" + "H: " + phone_home; 
			}
			
			if (! phone_mobile.isEmpty()) {
				record = record + "\n" + "M: " + phone_mobile; 
			}
			
			if (! phone_work.isEmpty()) {
				record = record + "\n" + "W: " + phone_work; 
			}
			
			if (! byyear.isEmpty()) {
				record = record + "\n" + "Birthday: " + byday + ". "
						+ bymonth + " " + byyear; 
			}
			
			if (! phone2.isEmpty()) {
				record = record + "\n" + "P: " + phone2; 
			}
			
			contactsWithPhones.add(record);	
		}
		return contactsWithPhones;
	}

}
