package com.astontech.virl.student.services.Impl;

import com.astontech.virl.student.domain.UserProfile;
import com.astontech.virl.student.repositories.UserProfileRepository;
import com.astontech.virl.student.services.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    UserProfileRepository userProfileRepo;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }

    @Override
    public Optional<UserProfile> findUserProfileById(String id) {
        return userProfileRepo.findById(id);
    }

    @Override
    public Optional<UserProfile> findUserProfileByName(String name) {
        return Optional.ofNullable(userProfileRepo.findByUsername(name));
    }

    @Override
    public UserProfile saveProfile(UserProfile userProfile) {
        return userProfileRepo.save(userProfile);
    }
}
