package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class PrintPhones extends TestBase {
	
	@Test
	public void testPrintPhones() throws Exception {

		SortedListOf<ContactData> contactsList = app.getContactHelper().getContactsWithPhonesList();
		
		SortedListOf<ContactData> printedList = app.getPrintPhonesHelper().getPrintedList();
		
		assertThat(printedList, equalTo(contactsList));
  }
  
}
