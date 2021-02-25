package com.astontech.virl.student.persistence;

import com.astontech.virl.student.Application;
import com.astontech.virl.student.domain.Mentee;
import com.astontech.virl.student.repositories.MenteeRepository;
import com.astontech.virl.student.services.MenteeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MenteePersistenceTest {

    @Autowired
    private MenteeRepository menteeRepository;

    @Autowired
    private MenteeService menteeService;

    @Test
    public void testRepository() {
        Mentee mentee = new Mentee();
        mentee.setName("Tim");
        mentee.setBu("cisco");
        mentee.setSite("MN");
        mentee.setAssignedVirlInstance("virl01");

        Mentee savedMentee = menteeRepository.save(mentee);

        assertNotNull(savedMentee.getId());
        Mentee foundMentee = menteeRepository.findById(savedMentee.getId()).orElse(null);
        assertNotNull(foundMentee);

        Mentee foundByName = menteeRepository.findAllByName("Tim");
        assertEquals("Tim", foundByName.getName());

        foundMentee.setSite("CA");

        Mentee updatedMentee = menteeRepository.save(foundMentee);
        assertEquals("CA", updatedMentee.getSite());

        menteeRepository.deleteById(updatedMentee.getId());

        assertEquals(Optional.empty(), menteeRepository.findById(updatedMentee.getId()));
    }

    @Test
    public void testMenteeService() {
        Mentee mentee = new Mentee();
        mentee.setName("Tim");
        mentee.setBu("cisco");
        mentee.setSite("MN");
        mentee.setAssignedVirlInstance("virl01");

        Mentee savedMentee = menteeService.saveMentee(mentee);
        assertNotNull(savedMentee.getId());
        Mentee foundMentee = menteeService.findMenteeById(savedMentee.getId());
        assertNotNull(foundMentee);

        Mentee foundByName = menteeService.findMenteeByName("Tim").get();
        assertEquals("Tim", foundByName.getName());

        foundMentee.setSite("CA");

        Mentee updatedMentee = menteeService.saveMentee(foundMentee);
        assertEquals("CA", updatedMentee.getSite());

        menteeService.deleteMentee(updatedMentee.getId());

        assertEquals(Optional.empty(), menteeRepository.findById(updatedMentee.getId()));

    }
}
