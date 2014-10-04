package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemoveTests extends TestBase {

	@Test
	public void deleteCertainContact() throws Exception {
		app.getNavigationHelper().openMainPage();

		List<ContactData> oldList = app.getContactHelper().getContactsList();

		int index = app.getContactHelper().generateIndexBasedOnListSize(oldList.size());
		app.getContactHelper().openContactForUpdate(index);
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().openMainPage();

	    List<ContactData> newList = app.getContactHelper().getContactsList(); 
	     
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList.size(), oldList.size());
	    assertEquals(newList, oldList);

	}

}
