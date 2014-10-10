package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactRemoveTests extends TestBase {

	@Test
	public void deleteCertainContact() throws Exception {
		
		SortedListOf<ContactData> oldList = app.getContactHelper().getContactsList();

		int index = app.getContactHelper().generateIndexBasedOnListSize(oldList.size());
		app.getContactHelper().deleteContact(index);

		SortedListOf<ContactData> newList = app.getContactHelper().getContactsList(); 

		assertThat(newList, equalTo(oldList.without(index)));
	}

}
