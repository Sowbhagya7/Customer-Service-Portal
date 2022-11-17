package com.customer.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String customername;
private String password;
private String address;
private String state;
private String country;
private String emailId;
private String pan;
private long contactnumber;
private String dob;
private String contactPreference;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPan() {
	return pan;
}
public void setPan(String pan) {
	this.pan = pan;
}
public long getContactnumber() {
	return contactnumber;
}
public void setContactnumber(long contactnumber) {
	this.contactnumber = contactnumber;
}

public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getContactPreference() {
	return contactPreference;
}
public void setContactPreference(String contactPreference) {
	this.contactPreference = contactPreference;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", customername=" + customername + ", password=" + password + ", address=" + address
			+ ", state=" + state + ", country=" + country + ", emailId=" + emailId + ", pan=" + pan + ", contactnumber="
			+ contactnumber + ", dob=" + dob + ", contactPreference=" + contactPreference + "]";
}




}
