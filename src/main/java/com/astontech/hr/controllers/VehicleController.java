package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleModelService vehicleModelService;

    @Autowired
    VehicleMakeService vehicleMakeService;

    private static final Logger log = LogManager.getLogger(AdminController.class);

    @RequestMapping(value = "/admin/vehicle/add", method= RequestMethod.GET)
    public String adminVehicleGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method= RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model) {
        Vehicle vehicle = new Vehicle();
        try {
            VehicleMake vehicleMake = vehicleMakeService.getOrCreateVehicleMakeByName(vehicleVO.getVehicleMakeName());
            VehicleModel vehicleModel = vehicleModelService.getOrCreateVehicleModelByName(vehicleVO.getVehicleModelName(), vehicleMake);
            vehicle.setVehicleModel(vehicleModel);
            vehicle.setVehicleYear(vehicleVO.getVehicleYear());
            vehicle.setColor(vehicleVO.getColor());
            vehicle.setLicensePlate(vehicleVO.getLicensePlate());
            vehicle.setPurchased(vehicleVO.getPurchased());
            vehicle.setPurchaseDate(vehicleVO.getPurchaseDate());
            vehicle.setPurchasePrice(vehicleVO.getPurchasePrice());
            vehicle.setVIN(vehicleVO.getVIN());
            vehicleService.saveVehicle(vehicle);
            model.addAttribute("vehicleVO", new VehicleVO());
            model.addAttribute("successAlert", "visible");
        } catch (Exception ex) {
            model.addAttribute("errorMessage",ex);
            model.addAttribute("errorAlert", "visible");
        }

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method= RequestMethod.GET)
    public String adminVehicleList(Model model) {
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        return "admin/vehicle/vehicle_lists";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{id}", method= RequestMethod.GET)
    public String vehicleEdit(@PathVariable int id, Model model) {
        Vehicle v = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", v);
        return "admin/vehicle/vehicle_edit";
    }
    @RequestMapping(value="admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdate(Vehicle vehicle, Model model) {
//        Vehicle dbVehicle = vehicleService.getVehicleById(vehicle.getId());
        VehicleMake vehicleMake = vehicleMakeService.getOrCreateVehicleMakeByName(vehicle.getVehicleModel().getVehicleMake().getVehicleMakeName());
//        vehicle.getVehicleModel().setVehicleMake(vehicleMake);

        vehicle.setVehicleModel(vehicleModelService.getOrCreateVehicleModelByName(vehicle.getVehicleModel().getVehicleModelName(),vehicleMake));
        vehicleService.saveVehicle(vehicle);
        return "redirect:/admin/vehicle/edit/"+vehicle.getId();
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method= RequestMethod.GET)
    public String vehicleDelete(@PathVariable int id, Model model) {

        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicle/list";
    }

}
