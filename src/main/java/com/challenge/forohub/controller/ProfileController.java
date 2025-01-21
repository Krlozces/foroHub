package com.challenge.forohub.controller;

import com.challenge.forohub.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final IProfileService iProfileService;

    @Autowired
    public ProfileController(IProfileService iProfileService) {
        this.iProfileService = iProfileService;
    }
}
