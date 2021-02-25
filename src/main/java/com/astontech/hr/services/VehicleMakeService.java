package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

public interface VehicleMakeService {

    Iterable<VehicleMake> getAllVehicleMakes();
    VehicleMake getVehicleMakeById(Integer id);
    VehicleMake getOrCreateVehicleMakeByName(String makeName);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);
    void deleteVehicleMake(Integer id);
}
