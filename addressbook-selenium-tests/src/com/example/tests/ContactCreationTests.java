package com.example.tests;

//import org.junit.*;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

@Test
  public void testAddNonEmptyContact() throws Exception {
    ContactData contact = new ContactData();
    contact.contact_firstname = "Bogdan";
    contact.contact_lastname = "Laukhin";
    contact.contact_address = "ak. Dubinovici, 20, Balt, Moldova";
    contact.contact_phone_home = "+373.231.62.114"; 
    contact.contact_phone_mobile = "+373.6.984.0320";     		
    contact.contact_email = "bodyagmail@yandex.com";
    contact.contact_byyear = "1980";
    contact.contact_address2 = "Pushkina 42, Chisinau, Moldova";
    contact.contact_phone2 = "+373.022.25.7070";

    openMainPage();
    addNewContact();
	fillContactForm(contact);
    submitContactForm();
    openMainPage();
  }

@Test
  public void testAddEmptyContact() throws Exception {
	openMainPage();
    addNewContact();
    fillContactForm(new ContactData());
    submitContactForm();
    openMainPage();
  }
  
}
