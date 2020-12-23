package com.bridgelabz.greetingapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.dto.ContactDetailDTO;
import com.bridgelabz.greetingapp.dto.ResponseDTO;
import com.bridgelabz.greetingapp.models.ContactDetail;
import com.bridgelabz.greetingapp.services.IAddressBookService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/addressbook")
public class AddressBookAppController {

	@Autowired
	private IAddressBookService addressBookService;
	
	/**
	 * @return
	 */
	@GetMapping(value = {"/contactlist"})
	public ResponseEntity<List<ContactDetail>> getContactList() {
		return new ResponseEntity<List<ContactDetail>>( addressBookService.getContacts(), HttpStatus.OK) ;
	}
	
	/**
	 * @param contactDto
	 * @return
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> addContactDetails(@Valid @RequestBody ContactDetailDTO contactDto) {
		ContactDetail contact = addressBookService.addContactDetail(contactDto);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Added new contact data"), HttpStatus.CREATED);
	}
	
	/**
	 * @param id
	 * @param contactDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateContactDetails(@PathVariable("id") int id, @RequestBody ContactDetailDTO contactDto){
		ContactDetail contact = addressBookService.updateContactDetails(id, contactDto); 
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Updated contact details data"), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<ResponseDTO> deleteContactDetails(@PathVariable("id") int id){
		addressBookService.deleteContactData(id);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Deleted data successfully"),HttpStatus.OK);
	}
	
}
