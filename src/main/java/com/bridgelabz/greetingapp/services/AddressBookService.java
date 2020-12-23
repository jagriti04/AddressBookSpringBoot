package com.bridgelabz.greetingapp.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.dto.ContactDetailDTO;
import com.bridgelabz.greetingapp.models.ContactDetail;
import com.bridgelabz.greetingapp.repository.AddressBookRepository;

@Service
public class AddressBookService  implements IAddressBookService{

	@Autowired
	private AddressBookRepository addressBookRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ContactDetail> getContacts() {
		List<ContactDetail> listOfContacts = addressBookRepo.findAll();
		if (listOfContacts == null || listOfContacts.isEmpty()) {
			System.out.println("No data found");
		}
		return listOfContacts;
	}

	@Override
	public ContactDetail addContactDetail(ContactDetailDTO contactDto) {
		ContactDetail contact = modelMapper.map(contactDto, ContactDetail.class);
		return addressBookRepo.save(contact);
	}

	@Override
	public ContactDetail updateContactDetails(int id, ContactDetailDTO contactDto) {
		ContactDetail contact = addressBookRepo.findById(id);
		modelMapper.map(contactDto, contact);
		return addressBookRepo.save(contact);
	}

	@Override
	public void deleteContactData(int id) {
		ContactDetail contact = addressBookRepo.findById(id);
		addressBookRepo.deleteById(id);
	}
}
