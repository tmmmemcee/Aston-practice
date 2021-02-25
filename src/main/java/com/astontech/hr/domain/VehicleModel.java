package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class VehicleModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleModelName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private VehicleMake vehicleMake;

    public VehicleModel() {
    }

    public VehicleModel(String model) {
        this.vehicleModelName = model;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleModel)) return false;
        VehicleModel that = (VehicleModel) o;
        return id.equals(that.id) && version.equals(that.version) && vehicleModelName.equals(that.vehicleModelName) && vehicleMake.equals(that.vehicleMake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, vehicleModelName, vehicleMake);
    }
}
