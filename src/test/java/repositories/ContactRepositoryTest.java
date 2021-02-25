package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class ContactRepositoryTest {
    @Autowired
    ContactRepository contactRepository;

    @Test
    public void testSaveContact(){
        Contact contact = new Contact("Joe Louis");
        assertNull(contact.getId());
        contactRepository.save(contact);
        assertNotNull(contact.getId());

        Contact fetchedContact = contactRepository.findById(contact.getId()).get();
        assertEquals(contact.getId(), fetchedContact.getId());

    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("Joe Louis");
        contactRepository.save(contact);
        contactRepository.deleteById(contact.getId());
        assertTrue(contactRepository.findById(contact.getId()).isEmpty());
    }
}
