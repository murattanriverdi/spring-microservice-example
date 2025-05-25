package com.murattanriverdi.service.impl;

import com.murattanriverdi.document.UserProfile;
import com.murattanriverdi.dto.request.CreateUserRequestDto;
import com.murattanriverdi.repository.UserProfileRepository;
import com.murattanriverdi.service.IUserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserProfileService implements IUserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final CacheManager cacheManager;

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

    @Override
    @Cacheable("upper-name")
    public String upperName(String name) {
        String result = name.toUpperCase();
        try{
            Thread.sleep(3000);
        }catch (Exception e){

        }
        return result;
    }

    public void clearCache(){
        Objects.requireNonNull(cacheManager.getCache("upper-name")).clear();
    }
}
