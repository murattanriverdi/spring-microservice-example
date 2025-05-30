package com.murattanriverdi.manager;

import com.murattanriverdi.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.murattanriverdi.config.UserFeignClientUrls.USER_PROFILE_MANAGER;
import static com.murattanriverdi.config.UserFeignClientUrls.CREATE_USER;

@FeignClient(url = USER_PROFILE_MANAGER, name = "userProfileManager")
public interface IUserProfileManager {

    @PostMapping(CREATE_USER)
    ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto);
}
