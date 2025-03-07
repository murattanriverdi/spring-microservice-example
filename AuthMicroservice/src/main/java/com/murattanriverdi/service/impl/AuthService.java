package com.murattanriverdi.service.impl;

import com.murattanriverdi.dto.request.LoginRequestDto;
import com.murattanriverdi.dto.request.RegisterRequestDto;
import com.murattanriverdi.entity.Auth;
import com.murattanriverdi.repository.AuthRepository;
import com.murattanriverdi.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AuthRepository authRepository;

    @Override
    public Auth register(RegisterRequestDto registerRequestDto) {
        return authRepository.save(Auth
                .builder()
                .username(registerRequestDto.getUsername())
                .email(registerRequestDto.getEmail())
                .password(registerRequestDto.getPassword())
                .build());
    }

    @Override
    public Boolean login(LoginRequestDto loginRequestDto) {
        // amaç microservisler olduğundan login işlerimi basit şekilde yapıldı.
        return authRepository.existsByUsernameAndPassword(loginRequestDto.getUsername(), loginRequestDto.getPassword());
    }
}
