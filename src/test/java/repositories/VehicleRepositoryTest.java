package repositories;


import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class VehicleRepositoryTest {
    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    public void testSaveVehicle() {
        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleYear(2021);
        vehicle.setLicensePlate("TEST12");
        vehicle.setVIN("TESTVIN");
        vehicle.setColor("Red");
        vehicle.setPurchased(true);
        vehicle.setPurchasePrice(2000);


        assertNull(vehicle.getId());
        vehicleRepository.save(vehicle);
        assertNotNull(vehicle.getId());

        Vehicle fetchedVehicle = vehicleRepository.findById(vehicle.getId()).get();
        assertNotNull(fetchedVehicle);
        assertEquals(vehicle.getId(), fetchedVehicle.getId());

        fetchedVehicle.setLicensePlate("RETEST");
        vehicleRepository.save(fetchedVehicle);

        Vehicle updatedVehicle = vehicleRepository.findById(fetchedVehicle.getId()).get();
        assertEquals(updatedVehicle.getLicensePlate(),fetchedVehicle.getLicensePlate());

    }
}
