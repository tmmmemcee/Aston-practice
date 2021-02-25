package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.repositories.VehicleMakeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class VehicleMakeRepositoryTest {
    @Autowired
    VehicleMakeRepository vehicleMakeRepository;

    @Test
    public void saveVehicleMakeSave() {
        VehicleMake vehicleMake = new VehicleMake("Fiat");
        assertNull(vehicleMake.getId());

        vehicleMakeRepository.save(vehicleMake);
        assertNotNull(vehicleMake.getId());

        VehicleMake fetchedVehicleMake = vehicleMakeRepository.findById(vehicleMake.getId()).get();
        assertEquals(vehicleMake.getId(), fetchedVehicleMake.getId());

    }

    @Test
    public void getVehicleMakeByNameTest() {
        VehicleMake vehicleMake = new VehicleMake("Audi");
        vehicleMakeRepository.save(vehicleMake);
        VehicleMake fetchedVehicle = vehicleMakeRepository.findByVehicleMakeName("Audi");
        assertEquals(fetchedVehicle.getId(), vehicleMake.getId());

        VehicleMake fetchedVehicle2 = vehicleMakeRepository.findByVehicleMakeNameIgnoreCase("audi").get();
        assertEquals(fetchedVehicle2.getId(), vehicleMake.getId());
    }


}
