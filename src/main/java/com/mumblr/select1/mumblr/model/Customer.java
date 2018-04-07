package com.mumblr.select1.mumblr;

import org.springframework.data.annotation.Id;


public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

	public boolean emailVerified;
	
    public Customer() {}

    public Customer(String firstName, String lastName, boolean emailVerified) {
        this.firstName = firstName;
        this.lastName = lastName;
		this.emailVerified = emailVerified;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}