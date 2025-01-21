package com.challenge.forohub.controller;

import com.challenge.forohub.entity.User;
import com.challenge.forohub.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    /*@GetMapping
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.);
    }*/
}
