package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehicleModelRepository extends CrudRepository<VehicleModel,Integer> {
    VehicleModel findByVehicleModelName(String vehicleModelName);
    Optional<VehicleModel> findByVehicleModelNameIgnoreCase(String vehicleModelName);

}
