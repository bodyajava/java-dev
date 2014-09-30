package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return  this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}
}