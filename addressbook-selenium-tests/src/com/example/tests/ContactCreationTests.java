package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testAddNonEmptyContact(ContactData contact) throws Exception {

		SortedListOf<ContactData> oldList = app.getContactHelper().getContactsList();
		
		app.getContactHelper().createContact(contact);
		
		SortedListOf<ContactData> newList = app.getContactHelper().getContactsList();
		
		assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
  
}
