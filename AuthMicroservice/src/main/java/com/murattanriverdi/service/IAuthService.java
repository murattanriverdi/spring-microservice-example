package com.murattanriverdi.service;

import com.murattanriverdi.dto.request.LoginRequestDto;
import com.murattanriverdi.dto.request.RegisterRequestDto;
import com.murattanriverdi.entity.Auth;

public interface IAuthService {
    Auth register(RegisterRequestDto registerRequestDto);

    Boolean login(LoginRequestDto loginRequestDto);
}
