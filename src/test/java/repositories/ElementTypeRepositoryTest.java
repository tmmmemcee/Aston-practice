package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
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
public class ElementTypeRepositoryTest {


    @Autowired
    private ElementTypeRepository elementTypeRepository;


    @Test
    public void testSaveElementType() {
        ElementType elementType = new ElementType("Cell");
        assertNull(elementType.getId());
        elementTypeRepository.save(elementType);
        assertNotNull(elementType.getId());

        ElementType foundElementType = elementTypeRepository.findById(elementType.getId()).get();
        assertNotNull(foundElementType);
        assertEquals(elementType.getId(),foundElementType.getId());

    }

    @Test
    public void testfindAllElementTypeByType() {
        ElementType elementType = new ElementType("Work");
        elementTypeRepository.save(elementType);
        ElementType elementType2 = new ElementType("Work");
        elementTypeRepository.save(elementType2);

        List<ElementType> retrievedElementType = elementTypeRepository.findAllElementTypeByElementTypeName("Work");

        long count =0;
        for (ElementType et : retrievedElementType) {
            count++;
        }

        assertEquals(count, 2);

    }

    @Test
    public void testFindElementTypeByContainsElement(){
        ElementType elementType = new ElementType("Home");
        List<Element> elements = new ArrayList<>();
        Element element = new Element("Phone");
        elements.add(element);
        elementType.setElementList(elements);
        elementTypeRepository.save(elementType);
        List<ElementType> elementTypes = elementTypeRepository.findAllElementTypeByElementListContains(element);
        long count = 0;

        for(ElementType et : elementTypes) {
            count++;
        }


        assertEquals(count, 1);


    }
}
