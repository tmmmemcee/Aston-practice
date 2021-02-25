package com.astontech.virl.student.services;

import com.astontech.virl.student.domain.UserProfile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserProfileService {

    Optional<UserProfile> findUserProfileById(String id);
    Optional<UserProfile> findUserProfileByName(String name);

    UserProfile saveProfile(UserProfile userProfile);
}
