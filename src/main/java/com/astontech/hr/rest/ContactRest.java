package com.astontech.hr.rest;

import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.domain.VO.ContactVO;
import com.astontech.hr.services.AddressService;
import com.astontech.hr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/contact")
public class ContactRest {
    @Autowired
    ContactService contactService;

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Contact> getAll() {
        return contactService.listAllContacts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getContactById(@PathVariable int id) {
        return contactService.findContactById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Contact save(@ModelAttribute ContactVO contactVO){
        Contact contact = contactService.getOrCreateContactById(contactVO.getContactId());
        Address address = addressService.getOrCreateAddressById(contactVO.getAddressId());
        contact.setContactName(contactVO.getContactName());
        address.setAddressName(contactVO.getAddressName());
        address.setStreet(contactVO.getStreet());
        address.setStreet2(contactVO.getStreet2());
        address.setCity(contactVO.getCity());
        address.setState(contactVO.getState());
        addressService.saveAddress(address);
        contact.setAddress(address);
        contact.setCreateDate(new Date());
        return contactService.saveContact(contact);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            contactService.deleteContact(id);
            result = true;
        } catch (Exception ex) {

        }
        return result;
    }
}
