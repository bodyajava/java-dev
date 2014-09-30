package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemoveTests extends TestBase {

	@Test
	public void deleteCertainContact() throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old list state
		List<ContactData> oldList = app.getContactHelper().getContactsList();

		// actions
		app.getContactHelper().openContactForUpdate(0);
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().openMainPage();

		// save new list state
	    List<ContactData> newList = app.getContactHelper().getContactsList(); 
	    
	    // compare list's states 
	    oldList.remove(0);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList.size(), oldList.size());
	    assertEquals(newList, oldList);

	}

}
