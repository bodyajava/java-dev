package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testAddNonEmptyContact(ContactData contact) throws Exception {

		app.getNavigationHelper().openMainPage();
    
		List<ContactData> oldList = app.getContactHelper().getContactsList();

		app.getContactHelper().addNewContact();
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitNewContactForm();
		app.getNavigationHelper().openMainPage();

		List<ContactData> newList = app.getContactHelper().getContactsList(); 
    
		assertEquals(newList.size(), oldList.size() + 1); 
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
  }
  
}
