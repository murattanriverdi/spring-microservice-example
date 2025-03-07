package com.murattanriverdi.service.impl;

import com.murattanriverdi.dto.request.CreateUserRequestDto;
import com.murattanriverdi.dto.request.LoginRequestDto;
import com.murattanriverdi.dto.request.RegisterRequestDto;
import com.murattanriverdi.entity.Auth;
import com.murattanriverdi.manager.UserProfileManager;
import com.murattanriverdi.repository.AuthRepository;
import com.murattanriverdi.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AuthRepository authRepository;

    private final UserProfileManager userProfileManager;

    @Override
    @Transactional
    public Auth register(RegisterRequestDto registerRequestDto) {
        Auth auth=  authRepository.save(Auth
                .builder()
                .username(registerRequestDto.getUsername())
                .email(registerRequestDto.getEmail())
                .password(registerRequestDto.getPassword())
                .build());

        userProfileManager.createUser(CreateUserRequestDto.builder()
                        .authId(auth.getId())
                        .email(auth.getEmail())
                        .username(auth.getUsername())
                .build());
        return auth;
    }

    @Override
    public Boolean login(LoginRequestDto loginRequestDto) {
        // amaç microservisler olduğundan login işlerimi basit şekilde yapıldı.
        return authRepository.existsByUsernameAndPassword(loginRequestDto.getUsername(), loginRequestDto.getPassword());
    }
}
