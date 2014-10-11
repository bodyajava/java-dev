package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class PrintPhonesHelper extends HelperBase {
	
	public PrintPhonesHelper(ApplicationManager manager) {
		super(manager);
	}

	public SortedListOf<ContactData> getPrintedList() {
		manager.navigateTo().printPhonesPage();
		
		SortedListOf<ContactData> printedContacts = new SortedListOf<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
		int index = rows.size();
		
		for (int i = 0; i < index; i++) {
			
			for (int x = 1; x < 4; x++) {
				String cell = rows.get(i).findElement(By.xpath("//td["+ x +"]")).getText();
				if (cell != ".") {
					String firstname = rows.get(i).findElement(By.xpath("//td["+ x +"]/b")).getText();
					String lastname = rows.get(i).findElement(By.xpath("//td["+ x +"]/b")).getText();
					// String phone = rows.get(i).findElement(By.xpath("//td["+ x +"]/br[1]/following-sibling::text()[1]")).getText();
					//String phone = rows.get(i).findElement(By.xpath("//td["+ x +"]")).;
					//String phone_home = phone.substring(phone.indexOf("H:") + 3);
					
					printedContacts.add(new ContactData()
						.withFirstname(firstname)
						.withLastname(lastname));
						//.withPhoneHome(phone_home));				
				}
			}
		}
		manager.navigateTo().storefront();
		return printedContacts;
	}

	public SortedListOf<ContactData> fixPrintedList(
			SortedListOf<ContactData> printedList) {
		int size = printedList.size();
		
		for (int i = size; i > size - 2; i--) {
			if (printedList.get(size) == null) {
				printedList.without(size);
			} 
		}
		return printedList;
	}


}
