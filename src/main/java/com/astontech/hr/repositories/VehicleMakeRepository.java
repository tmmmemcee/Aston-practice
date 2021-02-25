package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehicleMakeRepository extends CrudRepository<VehicleMake,Integer> {
    VehicleMake findByVehicleMakeName(String vehicleMakeName);
    Optional<VehicleMake> findByVehicleMakeNameIgnoreCase(String vehicleMakeName);
}
