package com.example.tests;

public class ContactData {
	public String contact_firstname;
	public String contact_lastname;
	public String contact_address;
	public String contact_phone_home;
	public String contact_phone_mobile;
	public String contact_email;
	public String contact_byyear;
	public String contact_address2;
	public String contact_phone2;

	public ContactData(String contact_firstname, String contact_lastname,
			String contact_address, String contact_phone_home,
			String contact_phone_mobile, String contact_email,
			String contact_byyear, String contact_address2,
			String contact_phone2) {
		this.contact_firstname = contact_firstname;
		this.contact_lastname = contact_lastname;
		this.contact_address = contact_address;
		this.contact_phone_home = contact_phone_home;
		this.contact_phone_mobile = contact_phone_mobile;
		this.contact_email = contact_email;
		this.contact_byyear = contact_byyear;
		this.contact_address2 = contact_address2;
		this.contact_phone2 = contact_phone2;
	}

	public ContactData() {
	}
}