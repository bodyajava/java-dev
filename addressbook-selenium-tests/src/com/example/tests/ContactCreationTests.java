package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import java.io.File;
import java.io.IOException;

public class ContactCreationTests extends TestBase {
	
	@DataProvider
	public static Iterator<Object[]> randomValidContactGenerator() throws IOException {
		return wrapContactsIntoObjects(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testAddNonEmptyContact(ContactData contact) throws Exception {

		SortedListOf<ContactData> oldList = app.getContactHelper().getContactsList();
		
		app.getContactHelper().createContact(contact);
		
		SortedListOf<ContactData> newList = app.getContactHelper().getContactsList();
		
		assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
  
}
