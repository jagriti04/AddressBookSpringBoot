package com.bridgelabz.greetingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.greetingapp.models.ContactDetail;

public interface AddressBookRepository extends JpaRepository<ContactDetail, Integer> {

	ContactDetail findById(int id);
}
