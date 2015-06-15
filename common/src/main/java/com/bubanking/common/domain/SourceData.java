package com.bubanking.common.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="source_data")
public class SourceData {
	
	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fullName;
	private String gender;
	private String locale;
	private String email;
	
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public String getGender() {
		return gender;
	}
	public String getLocale() {
		return locale;
	}
	public String getEmail() {
		return email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
	
	

}
