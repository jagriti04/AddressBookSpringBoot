package com.bridgelabz.greetingapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.models.ContactDetail;
import com.bridgelabz.greetingapp.services.IAddressBookService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/addressbook")
public class AddressBookAppController {

	@Autowired
	private IAddressBookService addressBookService;
	
	@GetMapping
	public String demo() {
		return "This is for testing";
	}
	
	@GetMapping(value = {"/contactlist"})
	public ResponseEntity<List<ContactDetail>> getContactList() {
		return new ResponseEntity<List<ContactDetail>>( addressBookService.getContacts(), HttpStatus.OK) ;
	}
}
