package com.bridgelabz.greetingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ContactDetailDTO {

	public String name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone;
	
	public ContactDetailDTO() {
		
	}
}
