package com.murattanriverdi.service;

import com.murattanriverdi.document.UserProfile;
import com.murattanriverdi.dto.request.CreateUserRequestDto;

import java.util.List;

public interface IUserProfileService {
    void createUser(CreateUserRequestDto dto);

    List<UserProfile> getAllUsers();
}
