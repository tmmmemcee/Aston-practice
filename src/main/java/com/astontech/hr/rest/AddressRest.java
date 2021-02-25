package com.astontech.hr.rest;

import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressRest {
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Address> getAll() {
        return addressService.listAllAddresses();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getAddressById(@PathVariable int id) {
        return addressService.findAddressById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Address save(@ModelAttribute Address address){
        return addressService.saveAddress(address);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;
        try {
            addressService.deleteAddress(id);
            result = true;
        } catch (Exception ex) {

        }
        return result;
    }

}
