package com.example.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testAddNonEmptyContact(ContactData contact) throws Exception {

		SortedListOf<ContactData> oldList = app.getContactHelper().getContactsList();
		
		app.getContactHelper().createContact(contact);
		
		SortedListOf<ContactData> newList = app.getContactHelper().getContactsList();
		
		assertEquals(newList.size(), oldList.size() + 1); 
		oldList.add(contact);
		assertEquals(newList, oldList);
  }
  
}
