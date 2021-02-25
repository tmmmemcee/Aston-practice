package com.astontech.hr.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId")
    private Integer id;

    @Version
    private Integer version;

    private int vehicleYear;
    private String licensePlate;
    private String VIN;
    private String color;
    private Boolean isPurchased;
    private int purchasePrice;
    private Date purchaseDate;


    @ManyToOne(fetch = FetchType.EAGER)
    private VehicleModel VehicleModel;


    public Vehicle() {
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

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePLate) {
        this.licensePlate = licensePLate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getPurchased() {
        return isPurchased;
    }

    public void setPurchased(Boolean purchased) {
        isPurchased = purchased;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public com.astontech.hr.domain.VehicleModel getVehicleModel() {
        return VehicleModel;
    }

    public void setVehicleModel(com.astontech.hr.domain.VehicleModel vehicleModel) {
        VehicleModel = vehicleModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleYear == vehicle.vehicleYear && purchasePrice == vehicle.purchasePrice && id.equals(vehicle.id) && version.equals(vehicle.version) && licensePlate.equals(vehicle.licensePlate) && VIN.equals(vehicle.VIN) && color.equals(vehicle.color) && isPurchased.equals(vehicle.isPurchased) && Objects.equals(purchaseDate, vehicle.purchaseDate) && VehicleModel.equals(vehicle.VehicleModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, vehicleYear, licensePlate, VIN, color, isPurchased, purchasePrice, purchaseDate, VehicleModel);
    }
}
