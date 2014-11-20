package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactUpdateTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator", dataProviderClass = TestBase.class)
	public void updateCertainContact(ContactData contact) throws Exception {
	    
		//SortedListOf<ContactData> oldList = app.getContactHelper().getUIContacts();
		SortedListOf<ContactData> oldList = app.getModel().getContacts();

		int index = app.getContactHelper().generateIndexBasedOnListSize(oldList.size());
		ContactData candidate = app.getContactHelper().updateContact(contact, index);
		//int candidateIndex = app.getContactHelper().getIndexByName(oldList, candidate);

		//SortedListOf<ContactData> newList = app.getContactHelper().getUIContacts();
		SortedListOf<ContactData> newList = app.getModel().getContacts(); 
	    
	    //assertThat(newList, equalTo(oldList.without(candidateIndex).withAdded(contact)));
		assertThat(newList, equalTo(oldList));
		
		//assertThat(oldList.without(candidateIndex), equalTo(app.getHibernateHelper().listContacts()));
		//System.out.println("Compared with DB");
		//assertThat(oldList.without(candidateIndex), equalTo(app.getContactHelper().getUIContacts()));
		//System.out.println("Compared with UI");
	}

}
