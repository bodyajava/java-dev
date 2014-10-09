package com.example.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactUpdateTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void updateCertainContact(ContactData contact) throws Exception {
	    
	    app.navigateTo().mainPage();
	    SortedListOf<ContactData> oldList = app.getContactHelper().getContactsList();

		int index = app.getContactHelper().generateIndexBasedOnListSize(oldList.size());
		app.getContactHelper().updateContact(contact, index);

		SortedListOf<ContactData> newList = app.getContactHelper().getContactsList(); 
	    
		oldList.remove(index);
	    oldList.add(contact);
	    assertEquals(newList, oldList);
	}

}
