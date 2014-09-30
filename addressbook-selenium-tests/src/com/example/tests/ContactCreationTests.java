package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
//import org.junit.*;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testAddNonEmptyContact() throws Exception {
    ContactData contact = new ContactData();
    contact.firstname = "Aurika";
    contact.lastname = "Connel";
    contact.address = "Shtefan Chel Mare, 20, Chisinau, Moldova";
    contact.phone_home = "+373.235.62.676"; 
    contact.phone_mobile = "+373.8.564.5420";
    contact.phone_work = "+373.7.932.5643";
    contact.email = "someemail@yandex.com";
    contact.email2 = "someemail@yandex.com";
    contact.byday = "29";
    contact.bymonth = "December";
    contact.byyear = "1975";
    contact.address2 = "Pushkina 42, Chisinau, Moldova";
    contact.phone2 = "+373.022.25.7070";

    app.getNavigationHelper().openMainPage();
    
    // save old list state
	List<ContactData> oldList = app.getContactHelper().getContactsList();

	// actions
    app.getContactHelper().addNewContact();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitNewContactForm();
    app.getNavigationHelper().openMainPage();

    // save new list state
    List<ContactData> newList = app.getContactHelper().getContactsList(); 
    
    // compare list's states
    assertEquals(newList.size(), oldList.size() + 1);
    contact.firstname = contact.firstname + " " + contact.lastname; 
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }

  @Test
  public void testAddEmptyContact() throws Exception {
	ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "");
	app.getNavigationHelper().openMainPage();
	// save old list state
	List<ContactData> oldList = app.getContactHelper().getContactsList();

	// actions
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitNewContactForm();
    app.getNavigationHelper().openMainPage();

    // save new list state
    List<ContactData> newList = app.getContactHelper().getContactsList(); 
    
    // compare list's states
    assertEquals(newList.size(), oldList.size() + 1);
    contact.firstname = contact.firstname + " " + contact.lastname; 
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
  
}
