package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ContactService contactService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        generateElementAndElementTypes();
//        generateVehicle();
//        generateAddressAndContacts();
    }

    private void generateElementAndElementTypes() {
        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));
        elementList.add(new Element("Samsung"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);
    }

    private void generateVehicle() {
        Vehicle vehicle = new Vehicle();

//        VehicleMake vehicleMake = vehicleMakeService.saveVehicleMake(new VehicleMake("Ford"));
        VehicleModel model = new VehicleModel("F-150");
        model.setVehicleMake(new VehicleMake("Ford"));
        vehicleModelService.saveVehicleModel(model);

        vehicle.setVehicleModel(model);
        vehicle.setVehicleYear(2021);
        vehicle.setPurchased(true);
        vehicle.setColor("Black");
        vehicle.setLicensePlate("FUN123");
        vehicle.setPurchaseDate(new Date(0));
        vehicleService.saveVehicle(vehicle);
    }

    private void generateAddressAndContacts() {
        Address address = new Address("Aston Technologies");
        address.setCity("St Louis Park");
        address.setState("MN");
        address.setStreet("5402 Parkdale Dr");
        addressService.saveAddress(address);
        Contact contact = new Contact("John Wayne");
        contact.setAddress(address);
        contact.setCreateDate(new java.util.Date());
        contactService.saveContact(contact);
    }




}
