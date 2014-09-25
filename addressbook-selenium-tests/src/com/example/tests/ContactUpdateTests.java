package com.example.tests;
import org.testng.annotations.Test;

public class ContactUpdateTests extends TestBase {

	@Test
	public void updateCertainContact() throws Exception {
	    ContactData contact = new ContactData();
	    contact.address = "Chreshatik str. 11/12, Kiev, Ukraine";
	    contact.phone_home = "+38.433.56.3442"; 
	    contact.phone_mobile = "+38.093.982.0320";
	    contact.phone_work = "+38.093.982.0332";
	    contact.email = "anyemail@gmail.com";
	    contact.email2 = "anyemail@yandex.com";
	    contact.byday = "29";
	    contact.bymonth = "December";
	    contact.byyear = "1976";
	    contact.address2 = "Pushkina 42, Chisinau, Moldova";
	    contact.phone2 = "+373.022.25.7070";
	    
	    app.getNavigationHelper().openMainPage();
		app.getContactHelper().openContactForUpdate(4);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitUpdatedContactForm();
	    app.getNavigationHelper().openMainPage();
	}

}
