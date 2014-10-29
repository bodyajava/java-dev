package com.example.fw;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillOutContactForm(contact);
		saveContactForm();
	}

	public Contact getFirstContact() {
		initGetContactData();
		cancelUpdateForm();
		
		Contact contact = new Contact()
			.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
			.setLastname(manager.getAutoItHelper().getText("TDBEdit11"));
		return contact;
	}



	//====================================================================================
			

	public void cancelUpdateForm() {
		manager.getAutoItHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 3000);
	}

	public void initGetContactData() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 3000)
			.click("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
	}

	public void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add")
			.winWaitAndActivate("Add Contact", "", 5000);
	}

	public void fillOutContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.firstname)
			.send("TDBEdit11", contact.lastname);
	}

	public void saveContactForm() {
		manager.getAutoItHelper()
			.click("TRbButton1")
			.winWaitAndActivate("AddressBook Portable", "", 3000);
	}



}
