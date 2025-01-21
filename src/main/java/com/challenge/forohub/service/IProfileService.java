package com.challenge.forohub.service;

import com.challenge.forohub.entity.Profile;

import java.util.List;

public interface IProfileService {
    Profile saveProfile(Profile profile);

    List<Profile> profiles();

    Profile updateProfile(Profile profile);

    Profile getById(Long id);

    void deleteProfile(Long id);
}
