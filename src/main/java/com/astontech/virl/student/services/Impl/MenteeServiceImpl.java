package com.astontech.virl.student.services.Impl;

import com.astontech.virl.student.domain.Mentee;
import com.astontech.virl.student.repositories.MenteeRepository;
import com.astontech.virl.student.services.MenteeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenteeServiceImpl implements MenteeService {

    MenteeRepository menteeRepository;

    public MenteeServiceImpl(MenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    @Override
    public Mentee saveMentee(Mentee mentee) {
        return menteeRepository.save(mentee);
    }


    @Override
    public Mentee findMenteeById(String id) {
        return menteeRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Mentee> findMenteeByName(String name) {
        return Optional.ofNullable(menteeRepository.findAllByName(name));
    }

    @Override
    public List<Mentee> findAllMentees() {
        List<Mentee> mentees = new ArrayList<>();
        menteeRepository.findAll().forEach(mentees::add);
        return mentees;
    }


    @Override
    public void deleteMentee(String id) {
        menteeRepository.deleteById(id);
    }
}
