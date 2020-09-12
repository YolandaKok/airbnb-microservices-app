package com.yolanda.kokkinou.airbnbservice.endpoints;

import com.yolanda.kokkinou.airbnbservice.dto.SignupRequest;
import com.yolanda.kokkinou.airbnbservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
public class UserApi {
    @Autowired
    private UserService service;

    @PostMapping("/signup")
    @ResponseStatus(CREATED)
    public void insertUser(@RequestBody SignupRequest request) {
        service.createUser(request.getUsername(), request.getPassword());
    }

    @PostMapping(value = "/login")
    public void signIn(@RequestBody SignupRequest request) {

    }
}
