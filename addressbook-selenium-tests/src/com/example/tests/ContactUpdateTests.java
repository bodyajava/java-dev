package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactUpdateTests extends TestBase {

	@Test
	public void updateCertainContact() throws Exception {
	    ContactData contact = new ContactData();
	    contact.firstname = "Jushe";
	    contact.lastname = " bobs";
	    contact.address = "Chreshatik str. 11/12, Kiev, Ukraine";
	    contact.phone_home = "+38.433.56.3442"; 
	    contact.phone_mobile = "+38.093.982.0320";
	    contact.phone_work = "+38.093.982.0332";
	    contact.email = "anyemail@gmail.com";
	    contact.email2 = "anyemail@yandex.com";
	    contact.byday = "29";
	    contact.bymonth = "December";
	    contact.byyear = "1976";
	    contact.address2 = "Pushkina 42, Chisinau, Moldova";
	    contact.phone2 = "+373.022.25.7070";
	    
	    app.getNavigationHelper().openMainPage();
	    
	    // save old list state
		List<ContactData> oldList = app.getContactHelper().getContactsList();

		// actions
		app.getContactHelper().openContactForUpdate(1);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitUpdatedContactForm();
	    app.getNavigationHelper().openMainPage();

	    // save new list state
	    List<ContactData> newList = app.getContactHelper().getContactsList(); 
	    
	    // compare list's states
	    contact.firstname = contact.firstname + " " + contact.lastname;
	    oldList.remove(1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}

}
