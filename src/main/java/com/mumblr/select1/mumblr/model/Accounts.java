package com.mumblr.select1.mumblr.model;

import org.springframework.data.annotation.Id;

public class Accounts { 
	
	@Id
	private String id;
	private String fname;
	private String lname;
	private String email;
	private String pass;
	private String b_month;
	private String b_day;
	private String b_year;
	
	public Accounts(){
		
	}
	
	public Accounts(String fname, String lname, String email, String pass, String b_month, String b_day, String b_year){
		this.fname = fname;
		this.lname = lname;	
		this.email = email;
		this.pass = pass;
		this.b_month = b_month;
		this.b_day = b_day;
		this.b_year = b_year;
	}
	
	@Override
    public String toString(){
        return String.format(
                "Accounts[id=%s, firstName='%s', lastName='%s', email='%s', pass='%s', b_month='%s', b_day='%s', b_year='%s']",
                id, fname, lname, email, pass, b_month, b_day, b_year);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getB_month() {
		return b_month;
	}

	public void setB_month(String b_month) {
		this.b_month = b_month;
	}

	public String getB_day() {
		return b_day;
	}

	public void setB_day(String b_day) {
		this.b_day = b_day;
	}

	public String getB_year() {
		return b_year;
	}

	public void setB_year(String b_year) {
		this.b_year = b_year;
	}
	
	
	
}