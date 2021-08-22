package ru.netology.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.rest.authorities.Authorities;
import ru.netology.rest.exception.InvalidCredentials;
import ru.netology.rest.exception.UnauthorizedUser;
import ru.netology.rest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.service = authorizationService;
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> invalid(InvalidCredentials e){
        return new ResponseEntity<>("Password or username is empty" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> unauthorized(UnauthorizedUser e){
        return new ResponseEntity<>("Unknown user" + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }


    @PostMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

}
