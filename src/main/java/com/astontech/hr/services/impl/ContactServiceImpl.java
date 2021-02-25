package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import com.astontech.hr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;



    @Override
    public Iterable<Contact> listAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findContactById(Integer id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact getOrCreateContactById(String id) {
        Optional<Contact> optionalContact = contactRepository.findById(Integer.parseInt(id));
        Contact contact;
        if (optionalContact.isEmpty()) {
            contact = new Contact();
            return contact;
        }
        return optionalContact.get();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Iterable<Contact> saveAllContats(Iterable<Contact> contacts) {
        return contactRepository.saveAll(contacts);
    }

    @Override
    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}
