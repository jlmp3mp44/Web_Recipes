package com.kpi.recipes.api.controller.auth;

import com.kpi.recipes.api.exception.UserAlreadyExistException;
import com.kpi.recipes.api.model.LoginBody;
import com.kpi.recipes.api.model.LoginResponse;
import com.kpi.recipes.api.model.RegistrationBody;
import com.kpi.recipes.model.User;
import com.kpi.recipes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthenticationController {
    private UserService userService;

    public AuthenticationController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody){
        String jwt =  userService.loginUser(loginBody);
        if(jwt ==  null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        else {
            LoginResponse loginResponse =  new LoginResponse();
            loginResponse.setJwt(jwt);
            return ResponseEntity.ok(loginResponse);
        }
    }
    @GetMapping("/me")
    public ResponseEntity<User> getLoggedInUserProfile(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

}
