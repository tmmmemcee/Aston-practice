package com.astontech.hr.services;

import ch.qos.logback.core.net.server.Client;
import com.astontech.hr.domain.Contact;

public interface ContactService {

    Iterable<Contact> listAllContacts();
    Contact findContactById(Integer id);
    Contact getOrCreateContactById(String Id);
    Contact saveContact(Contact contact);
    Iterable<Contact> saveAllContats(Iterable<Contact> contacts);
    void deleteContact(Integer id);
}
