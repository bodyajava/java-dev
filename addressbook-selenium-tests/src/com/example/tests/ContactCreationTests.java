package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator", dataProviderClass = TestBase.class)
	public void testAddNonEmptyContact(ContactData contact) throws Exception {

		//SortedListOf<ContactData> oldList = app.getContactHelper().getUIContacts();
		//SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
		SortedListOf<ContactData> oldList = app.getModel().getContacts();
		
		app.getContactHelper().createContact(contact);
		
		//SortedListOf<ContactData> newList = app.getContactHelper().getUIContacts();
		SortedListOf<ContactData> newList = app.getModel().getContacts();
		
		//assertThat(newList, equalTo(oldList.withAdded(contact)));
		assertThat(newList, equalTo(oldList));
		
		if (checkMe()) {
			if ("yes".equals(app.getProperty("check.db"))) {
				assertThat(newList, equalTo(app.getHibernateHelper().listContacts()));
				System.out.println("Compared with DB");
			}
			if ("yes".equals(app.getProperty("check.ui"))) {
				assertThat(newList, equalTo(app.getContactHelper().getUIContacts()));
				System.out.println("Compared with UI");
			}
		}
  }
  
}
