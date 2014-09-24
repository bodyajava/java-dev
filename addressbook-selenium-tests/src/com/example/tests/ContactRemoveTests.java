package com.example.tests;
import org.testng.annotations.Test;

public class ContactRemoveTests extends TestBase {

	@Test
	public void deleteCertainContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openContactForUpdate(2);
		app.getContactHelper().deleteContact();
	    app.getNavigationHelper().openMainPage();
	}

}
