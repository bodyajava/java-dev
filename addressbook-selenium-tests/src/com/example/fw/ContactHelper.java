package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void addNewContact() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.phone_home);
		type(By.name("mobile"), contact.phone_mobile);
		type(By.name("work"), contact.phone_work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.byday);
	    selectByText(By.name("bmonth"), contact.bymonth);
		type(By.name("byear"), contact.byyear);
	    //selectByText(By.name("new_group"), "New Congregation");
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void submitNewContactForm() {
		click(By.name("submit"));
	}

	public void selectContactByIndex(int index) {
		index++; // = index + 1;
		click(By.xpath("//tr["+index+"]/td[1]/input"));
	}
	
	public void clickEditContactByIndex(int index) {
		index++;
		click(By.xpath("//tr["+index+"]/td[7]/a/img"));
	}

	public void openContactForUpdate(int index) {
		selectContactByIndex(index);		
		clickEditContactByIndex(index);
	}

	public void deleteContact() {
		click(By.xpath("//form[2]/input[2]"));
	}

	public void submitUpdatedContactForm() {
		click(By.xpath("//form[1]/input[11]"));
	}

}
