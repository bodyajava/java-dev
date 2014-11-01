package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	
	@Test
	public void createContactWithValidData() {
		Contact contact = new Contact().setFirstname("tester").setLastname("tester");
		app.getContactHelper().createContact(contact);
		Contact created = app.getContactHelper().getFirstContact();
		
		Assert.assertEquals(contact, created);
		
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} */
	}

}
