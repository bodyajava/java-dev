package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String phone_home;
	public String phone_mobile;
	public String phone_work;
	public String email;
	public String email2;
	public String byday;
	public String bymonth;
	public String byyear;
	public String address2;
	public String phone2;

	public ContactData(String contact_firstname, String contact_lastname,
			String contact_address, String contact_phone_home,
			String contact_phone_mobile, String contact_phone_work,
			String contact_email, String contact_email2,
			String contact_byday, String contact_bymonth,
			String contact_byyear, String contact_address2,
			String contact_phone2) {
		this.firstname = contact_firstname;
		this.lastname = contact_lastname;
		this.address = contact_address;
		this.phone_home = contact_phone_home;
		this.phone_mobile = contact_phone_mobile;
		this.phone_work = contact_phone_work;
		this.email = contact_email;
		this.email2 = contact_email2;
		this.byday = contact_byday;
		this.bymonth = contact_bymonth;
		this.byyear = contact_byyear;
		this.address2 = contact_address2;
		this.phone2 = contact_phone2;
	}

	public ContactData() {
	}
}