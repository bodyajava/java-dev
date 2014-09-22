package com.example.tests;
//import org.junit.*;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testAddNonEmptyContact() throws Exception {
    ContactData contact = new ContactData();
    contact.firstname = "Bogdan";
    contact.lastname = "Laukhin";
    contact.address = "ak. Dubinovici, 20, Balt, Moldova";
    contact.phone_home = "+373.231.62.114"; 
    contact.phone_mobile = "+373.6.984.0320";
    contact.phone_work = "+373.7.932.5643";
    contact.email = "bodyagmail@yandex.com";
    contact.email2 = "bodyagmail@yandex.ru";
    contact.byday = "29";
    contact.bymonth = "December";
    contact.byyear = "1980";
    contact.address2 = "Pushkina 42, Chisinau, Moldova";
    contact.phone2 = "+373.022.25.7070";

    app.getNavigationHelper().openMainPage();
    app.getContactHelper().addNewContact();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactForm();
    app.getNavigationHelper().openMainPage();
  }

  @Test
  public void testAddEmptyContact() throws Exception {
	ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "");
    //contact.byday = "-";
    //contact.bymonth = "-";
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactForm();
    app.getNavigationHelper().openMainPage();
  }
  
}
