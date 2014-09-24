package com.example.tests;
//import org.junit.*;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testAddNonEmptyContact() throws Exception {
    ContactData contact = new ContactData();
    contact.firstname = "John";
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
    app.getContactHelper().addNewContact();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitNewContactForm();
    app.getNavigationHelper().openMainPage();
  }

  @Test
  public void testAddEmptyContact() throws Exception {
	ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "");
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitNewContactForm();
    app.getNavigationHelper().openMainPage();
  }
  
}
