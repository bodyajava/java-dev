package com.example.tests;

import org.testng.annotations.Test;

public class ContactDeleteAllContacts extends TestBase {

	//@Test
	public void deleteAllContacts() {
		app.getContactHelper().deleteAllContacts();
	}

}
