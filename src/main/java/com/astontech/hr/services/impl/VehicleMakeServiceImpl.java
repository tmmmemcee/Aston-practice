package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleMakeServiceImpl implements VehicleMakeService {

    @Autowired
    VehicleMakeRepository vehicleMakeRepository;

    @Override
    public Iterable<VehicleMake> getAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public VehicleMake getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findById(id).get();
    }

    @Override
    public VehicleMake getOrCreateVehicleMakeByName(String makeName) {
        VehicleMake vehicleMake = vehicleMakeRepository.findByVehicleMakeName(makeName);
        if (vehicleMake==null) {
            vehicleMake = vehicleMakeRepository.save(new VehicleMake(makeName));
        }
        return vehicleMake;
    }


    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public void deleteVehicleMake(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
