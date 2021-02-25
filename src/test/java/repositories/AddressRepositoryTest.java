package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class AddressRepositoryTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void testSaveAddress() {
        Address address = new Address("Target");
        assertNull(address.getId());
        addressRepository.save(address);
        assertNotNull(address.getId());

        Address fetchedAddress = addressRepository.findById(address.getId()).get();
        assertEquals(address.getId(),fetchedAddress.getId());

    }

    @Test
    public void testDeleteAddress() {
        Address address = new Address("Cub Foods");
        addressRepository.save(address);
        int id = address.getId();
        addressRepository.deleteById(address.getId());
        assertTrue(addressRepository.findById(id).isEmpty());

    }

}
