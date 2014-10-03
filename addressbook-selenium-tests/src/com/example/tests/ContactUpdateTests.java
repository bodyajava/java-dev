package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ContactUpdateTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void updateCertainContact(ContactData contact) throws Exception {
	    
	    app.getNavigationHelper().openMainPage();
	    
		List<ContactData> oldList = app.getContactHelper().getContactsList();

		int index = app.getContactHelper().generateIndexBasedOnListSize(oldList.size());
		app.getContactHelper().openContactForUpdate(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitUpdatedContactForm();
	    app.getNavigationHelper().openMainPage();

	    List<ContactData> newList = app.getContactHelper().getContactsList(); 
	    
	    contact.firstname = contact.firstname + " " + contact.lastname;
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}

}
