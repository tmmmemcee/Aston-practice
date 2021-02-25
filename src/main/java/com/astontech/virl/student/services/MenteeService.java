package com.astontech.virl.student.services;

import com.astontech.virl.student.domain.Mentee;

import java.util.List;
import java.util.Optional;

public interface MenteeService {
    Mentee saveMentee(Mentee mentee);
    Mentee findMenteeById(String id);
    Optional<Mentee> findMenteeByName(String name);
    List<Mentee> findAllMentees();
    void deleteMentee(String id);
}
