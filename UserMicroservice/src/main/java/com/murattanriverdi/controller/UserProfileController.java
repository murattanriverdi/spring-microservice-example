package com.murattanriverdi.controller;

import com.murattanriverdi.document.UserProfile;
import com.murattanriverdi.dto.request.CreateUserRequestDto;
import com.murattanriverdi.service.IUserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.murattanriverdi.config.RestApis.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final IUserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto){
        userProfileService.createUser(dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL_USERS)
    public ResponseEntity<List<UserProfile>> getAllUsers(){
        return ResponseEntity.ok(userProfileService.getAllUsers());
    }


    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(String name){
        return ResponseEntity.ok(userProfileService.upperName(name));
    }
}
