package com.example.fw;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	
	private SortedListOf<GroupData> groups;
	private SortedListOf<ContactData> contacts;
	
	public SortedListOf<GroupData> getGroups() {
		return groups;	
	}
	
	public void setGroups(SortedListOf<GroupData> groups) {
		this.groups = groups;
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}

	public SortedListOf<ContactData> getContacts() {
		return contacts;	
	}
	
	public void setContacts(SortedListOf<ContactData> contacts) {
		this.contacts = contacts;
	}

	public ApplicationModel addContact(ContactData contact) {
		contacts.add(contact);
		return this;
	}

	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
	}

}
