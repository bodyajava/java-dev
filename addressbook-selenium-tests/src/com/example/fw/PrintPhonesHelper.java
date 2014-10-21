package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.utils.SortedListOf;

public class PrintPhonesHelper extends HelperBase {
	
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

}
