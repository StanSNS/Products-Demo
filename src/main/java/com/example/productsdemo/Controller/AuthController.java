package com.example.productsdemo.Controller;

import com.example.productsdemo.models.Entity.UserEntity;
import com.example.productsdemo.Repository.UserEntityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.productsdemo.Consts.Globals.GLOBAL_FRONTEND_URL;
import static com.example.productsdemo.Consts.Globals.IS_USER_LOGGED;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = GLOBAL_FRONTEND_URL)
@RequestMapping("/auth")
public class AuthController {

    private final UserEntityRepo userEntityRepo;

    @PostMapping("/login")
    public ResponseEntity<String> authUser(@RequestBody UserEntity user) {
        if (IS_USER_LOGGED) {
            return new ResponseEntity<>("User already logged in.", HttpStatus.FORBIDDEN);
        }

        UserEntity firstUser = userEntityRepo.findFirstByOrderByIdAsc();
        if (firstUser.equals(user)) {
            IS_USER_LOGGED = true;
            return new ResponseEntity<>("User authentication was successful.", HttpStatus.OK);
        }

        return new ResponseEntity<>("Wrong email or password.", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestBody UserEntity user) {
        if (!IS_USER_LOGGED) {
            return new ResponseEntity<>("User is not logged in.", HttpStatus.FORBIDDEN);
        }

        UserEntity firstUser = userEntityRepo.findFirstByOrderByIdAsc();
        if (firstUser.equals(user)) {
            IS_USER_LOGGED = false;
            return new ResponseEntity<>("User logout was successful.", HttpStatus.OK);
        }

        return new ResponseEntity<>("Wrong email or password.", HttpStatus.UNAUTHORIZED);
    }

}
