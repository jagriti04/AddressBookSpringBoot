package com.bridgelabz.greetingapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.models.ContactDetail;
import com.bridgelabz.greetingapp.repository.AddressBookRepository;

@Service
public class AddressBookService  implements IAddressBookService{

	@Autowired
	private AddressBookRepository addressBookRepo;
	
	@Override
	public List<ContactDetail> getContacts() {
		List<ContactDetail> listOfContacts = addressBookRepo.findAll();
		if (listOfContacts == null || listOfContacts.isEmpty()) {
			System.out.println("No data found");
		}
		return listOfContacts;
	}

	
}
