package com.bridgelabz.greetingapp.services;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.greetingapp.dto.ContactDetailDTO;
import com.bridgelabz.greetingapp.models.ContactDetail;

public interface IAddressBookService {

	List<ContactDetail> getContacts();

	ContactDetail addContactDetail(@Valid ContactDetailDTO contactDto);

	ContactDetail updateContactDetails(int id, ContactDetailDTO contactDto);

	void deleteContactData(int id);

}
