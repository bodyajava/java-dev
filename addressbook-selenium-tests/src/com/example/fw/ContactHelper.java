package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;
	private ContactData candidate;
	
	public SortedListOf<ContactData> getContactsList() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}

	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
		int index = rows.size();
		if (index > 2) {
			for (int i = 1; i < index - 1; i++) {
				String firstname = rows.get(i).findElement(By.xpath(".//td[3]")).getText();
				String lastname = rows.get(i).findElement(By.xpath(".//td[2]")).getText();
				cachedContacts.add(new ContactData()
					.withFirstname(firstname)
					.withLastname(lastname));
			}
		}
	}

	public void createContact(ContactData contact) {
		addNewContact();
		fillContactForm(contact);
		submitNewContactForm();
		returnToHomePage();	
		rebuildCache();
	}

	public ContactData updateContact(ContactData contact, int index) {
		openContactForUpdate(index);
		getCandidate();
		fillContactForm(contact);
		clickUpdateButton();
		returnToHomePage();
		rebuildCache();
		return candidate;
	}

	public ContactData deleteContact(int index) {
		openContactForUpdate(index);
		getCandidate();		
		clickDeleteButton();
		returnToHomePage();
		rebuildCache();
		return candidate;
	}

	public ContactHelper openContactForUpdate(int index) {		
		clickEditContactByIndex(index);
		return this;
	}

	
	// LOW LEVEL METHODS =================================================================================
	
	private void getCandidate() {
		candidate = new ContactData()
			.withFirstname(driver.findElement(By.xpath("//input[2]")).getAttribute("value"))
			.withLastname(driver.findElement(By.xpath("//input[3]")).getAttribute("value"));		
	}

	public ContactHelper addNewContact() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getPhone_home());
		type(By.name("mobile"), contact.getPhone_mobile());
		type(By.name("work"), contact.getPhone_work());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectDropDownItemByRandom("bday");
		selectDropDownItemByRandom("bmonth");
	    // selectByIndex(By.name("bday"), contact.byday);
		type(By.name("byear"), contact.getByyear());
		// selectDropDownItemByRandom("new_group");
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
		return this;
	}

	public ContactHelper submitNewContactForm() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public void selectContactByIndex(int index) {
		index = index + 2;
		click(By.xpath("//tr["+index+"]/td[1]/input"));
	}
	
	public void clickEditContactByIndex(int index) {
		index = index + 2;
		click(By.xpath("//tr["+index+"]/td[7]/a/img"));
	}

	public void clickDeleteButton() {
		click(By.xpath("//form[2]/input[2]"));
		cachedContacts = null;
	}

	public void clickUpdateButton() {
		click(By.xpath("//form[1]/input[11]"));
		cachedContacts = null;
	}

	public void returnToHomePage() {
	    click(By.linkText("home page"));
	}

	public void addNextContact() {
	    click(By.linkText("add next"));
	}

	public void deleteAllContacts() {
		List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
		int index = rows.size();
		for (int i = 0; i < index - 2; i++) {
			openContactForUpdate(0);
			clickDeleteButton();
			returnToHomePage();
		}
	}

	public int getIndexByName(SortedListOf<ContactData> oldList,
			ContactData candidate) {
		for (int i = 0; i < oldList.size(); i++) {
			ContactData contact = oldList.get(i);
	        if (contact.getFirstname().equals(candidate.getFirstname())
	        		&& contact.getLastname().equals(candidate.getLastname()))
	        {
	            return i;
	        }
	    } 
		return -1;
	}

	public SortedListOf<ContactData> getContactsWithPhonesList() {
		SortedListOf<ContactData> contactsWithPhones = new SortedListOf<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
		int index = rows.size();
		for (int i = 1; i < index - 1; i++) {
			String firstname = rows.get(i).findElement(By.xpath(".//td[3]")).getText();
			String lastname = rows.get(i).findElement(By.xpath(".//td[2]")).getText();
			//String phone_home = rows.get(i).findElement(By.xpath(".//td[5]")).getText();
			firstname = firstname + " " + lastname;
			lastname = firstname;
			contactsWithPhones.add(new ContactData()
				.withFirstname(firstname)
				.withLastname(lastname));
				//.withPhoneHome(phone_home));			
		}
		return contactsWithPhones;
	}

}
