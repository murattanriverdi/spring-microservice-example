package com.murattanriverdi.service.impl;

import com.murattanriverdi.document.UserProfile;
import com.murattanriverdi.dto.request.CreateUserRequestDto;
import com.murattanriverdi.repository.UserProfileRepository;
import com.murattanriverdi.service.IUserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService implements IUserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public void createUser(CreateUserRequestDto dto) {
        userProfileRepository.save(UserProfile.builder()
                        .authId(dto.getAuthId())
                        .username(dto.getUsername())
                        .email(dto.getEmail())
                .build());

    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }
}
