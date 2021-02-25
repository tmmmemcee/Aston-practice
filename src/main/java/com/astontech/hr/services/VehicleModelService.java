package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

public interface VehicleModelService {

    Iterable<VehicleModel> getAllVehicleModels();

    VehicleModel getVehicleModelById(Integer id);
    VehicleModel getOrCreateVehicleModelByName(String modelName, VehicleMake vehicleMake);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    void deleteVehicleModel(Integer id);
}
