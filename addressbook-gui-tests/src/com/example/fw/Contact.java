package com.example.fw;

public class Contact {

	public String firstname;
	public String lastname;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Contact setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public Contact setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

}
