package com.murattanriverdi.controller;

import com.murattanriverdi.dto.request.LoginRequestDto;
import com.murattanriverdi.dto.request.RegisterRequestDto;
import com.murattanriverdi.entity.Auth;
import com.murattanriverdi.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.murattanriverdi.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH_SERVICE)
public class AuthController {

    private final IAuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto registerRequestDto) {
        if(!registerRequestDto.getPassword().equals(registerRequestDto.getRePassword())){
            throw new RuntimeException("Parolalar uyuşmuyor");
        }
        return ResponseEntity.ok(authService.register(registerRequestDto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));

    }
}
