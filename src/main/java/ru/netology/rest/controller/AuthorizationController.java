package ru.netology.rest.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.rest.authorities.Authorities;
import ru.netology.rest.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service;

    @PostMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @RequestParam("user") String user,
                                            @Valid @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
