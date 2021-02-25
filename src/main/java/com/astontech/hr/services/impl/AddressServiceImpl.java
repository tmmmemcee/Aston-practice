package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import com.astontech.hr.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Iterable<Address> listAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address getOrCreateAddressById(String id) {
        Optional<Address> optionalAddress = addressRepository.findById(Integer.parseInt(id));
        if (optionalAddress.isEmpty()) {
            return new Address();
        }
        return optionalAddress.get();
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Iterable<Address> saveAllAddresses(Iterable<Address> addresses) {
        return addressRepository.saveAll(addresses);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}
