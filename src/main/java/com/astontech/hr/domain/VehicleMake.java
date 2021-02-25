package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class VehicleMake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleMakeId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleMakeName;
//
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    List<VehicleModel> vehicleModelList;

    public VehicleMake(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public VehicleMake() {
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

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

//    public List<VehicleModel> getVehicleModelList() {
//        return vehicleModelList;
//    }
//
//    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
//        this.vehicleModelList = vehicleModelList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleMake)) return false;
        VehicleMake that = (VehicleMake) o;
        return id.equals(that.id) && version.equals(that.version) && vehicleMakeName.equals(that.vehicleMakeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, vehicleMakeName);
    }
}
