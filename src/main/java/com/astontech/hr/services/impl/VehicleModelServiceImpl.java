package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    @Autowired
    VehicleModelRepository vehicleModelRepository;

    @Override
    public Iterable<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findById(id).get();
    }

    @Override
    public VehicleModel getOrCreateVehicleModelByName(String modelName, VehicleMake vehicleMake) {
        VehicleModel vehicleModel = vehicleModelRepository.findByVehicleModelName(modelName);
        if (vehicleModel ==null) {
            vehicleModel = new VehicleModel(modelName);
            vehicleModel.setVehicleMake(vehicleMake);
            return vehicleModelRepository.save(vehicleModel);
        }
        vehicleModel.setVehicleMake(vehicleMake);
        return vehicleModel;
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public void deleteVehicleModel(Integer id) {
        vehicleModelRepository.deleteById(id);

    }
}
