package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class VehicleModelRepositoryTest {
    @Autowired
    VehicleModelRepository vehicleModelRepository;

    @Test
    public void saveVehicleModelTest() {
        VehicleModel vehicleModel = new VehicleModel("500");
        assertNull(vehicleModel.getId());
        vehicleModelRepository.save(vehicleModel);
        assertNotNull(vehicleModel.getId());

    }

    @Test
    public void getVehicleModelByIdTest() {
        VehicleModel vehicleModel = new VehicleModel("Jetta");
        vehicleModelRepository.save(vehicleModel);

        VehicleModel vehicleModel1 = vehicleModelRepository.findById(vehicleModel.getId()).get();
    }

    @Test
    public void getVehicleModelByNameTest() {
        VehicleModel vehicleModel = new VehicleModel("Camry");
        vehicleModelRepository.save(vehicleModel);
        VehicleModel vehicleModel1 = vehicleModelRepository.findByVehicleModelName("Camry");
        assertEquals(vehicleModel.getId(),vehicleModel1.getId());

    }
}
