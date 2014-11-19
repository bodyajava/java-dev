package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactUpdateTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator", dataProviderClass = TestBase.class)
	public void updateCertainContact(ContactData contact) throws Exception {
	    
	    //SortedListOf<ContactData> oldList = app.getContactHelper().getContactsList();
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());

		int index = app.getContactHelper().generateIndexBasedOnListSize(oldList.size());
		ContactData candidate = app.getContactHelper().updateContact(contact, index);
		int candidateIndex = app.getContactHelper().getIndexByName(oldList, candidate);

		SortedListOf<ContactData> newList = app.getContactHelper().getContactsList(); 
	    
	    assertThat(newList, equalTo(oldList.without(candidateIndex).withAdded(contact)));
	}

}
