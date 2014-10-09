package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String phone_home;
	private String phone_mobile;
	private String phone_work;
	private String email;
	private String email2;
	private String byday;
	private String bymonth;
	private String byyear;
	private String address2;
	private String phone2;

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
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		//result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		  int res = this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		  if (res != 0) {
		    return res;
		  } else {
		    return  this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		  }
	}

	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withPhoneHome(String phone_home) {
		this.phone_home = phone_home;
		return this;
	}

	public ContactData withPhoneMobile(String phone_mobile) {
		this.phone_mobile = phone_mobile;
		return this;
	}

	public ContactData withPhoneWork(String phone_work) {
		this.phone_work = phone_work;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withDayOfBirth(String byday) {
		this.byday = byday;
		return this;
	}

	public ContactData withMonthOfBirth(String bymonth) {
		this.bymonth = bymonth;
		return this;
	}

	public ContactData withYearOfBirth(String byyear) {
		this.byyear = byyear;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone_home() {
		return phone_home;
	}

	public String getPhone_mobile() {
		return phone_mobile;
	}

	public String getPhone_work() {
		return phone_work;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getByday() {
		return byday;
	}

	public String getBymonth() {
		return bymonth;
	}

	public String getByyear() {
		return byyear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
	
}