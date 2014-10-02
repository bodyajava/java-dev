package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
//import org.junit.*;
import org.testng.annotations.Test;

import com.example.fw.GenerateDataHelper;

public class ContactCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator", dataProviderClass = GenerateDataHelper.class)
	public void testAddNonEmptyContact(ContactData contact) throws Exception {

		app.getNavigationHelper().openMainPage();
    
		List<ContactData> oldList = app.getContactHelper().getContactsList();

		app.getContactHelper().addNewContact();
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitNewContactForm();
		app.getNavigationHelper().openMainPage();

		List<ContactData> newList = app.getContactHelper().getContactsList(); 
    
		assertEquals(newList.size(), oldList.size() + 1);
		//contact.firstname = contact.firstname + " " + contact.lastname; 
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
  }
  
}
