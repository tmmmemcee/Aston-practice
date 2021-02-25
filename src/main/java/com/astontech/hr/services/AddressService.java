package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

public interface AddressService {
    Iterable<Address> listAllAddresses();
    Address findAddressById(Integer id);
    Address getOrCreateAddressById(String id);
    Address saveAddress(Address address);
    Iterable<Address> saveAllAddresses(Iterable<Address> addresses);

    void deleteAddress(Integer id);
}
