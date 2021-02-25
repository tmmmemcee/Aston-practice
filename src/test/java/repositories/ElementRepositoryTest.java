package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement() {
        Element element = new Element();
        element.setElementName("Phone");

        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        Element fetchedElement = elementRepository.findById(element.getId()).get();
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findById(element.getId()).get();
        assertEquals(updatedElement.getElementName(),"Email");

    }


    @Test
    public void testSaveElementList() {
        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.saveAll(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();
        int count = 0;
        for (Element e : elementList) {
            count++;
        }
        assertEquals(4,count);
    }

    @Test
    public void testFindByName() {
        Element element = new Element("FindTest");
        elementRepository.save(element);

        Element foundByName = elementRepository.findByElementName("FindTest");

        assertEquals(element.getId(), foundByName.getId());
    }

    @Test
    public void testFindByNameIgnoreCase() {
        Element element = new Element("CAP");
        elementRepository.save(element);

        Element foundByNameIgnoreCase = elementRepository.findByElementNameIgnoreCase("cap");

        assertEquals(element.getId(), foundByNameIgnoreCase.getId());
    }

    @Test
    public void testCountByElementName() {
        Element element1 = new Element("Name1");
        Element element2 = new Element("Name1");
        Element element3 = new Element("Name1");
        elementRepository.save(element1);
        elementRepository.save(element2);
        elementRepository.save(element3);

        long countfound  = elementRepository.countByElementName("Name1");

        assertEquals(countfound, 3);
    }

    @Test
    public void testFindAllByNameContains() {
        Element element1 = new Element("Name");
        Element element2 = new Element("Name");
        Element element3 = new Element("Name");
        elementRepository.save(element1);
        elementRepository.save(element2);
        elementRepository.save(element3);

        List<Element> foundElements = elementRepository.findAllByElementNameContains("ame");
        long count = 0;
        for (Element e : foundElements) {
            count++;
        }
        assertEquals(3,count);
    }
}
