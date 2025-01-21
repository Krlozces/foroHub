package com.challenge.forohub.controller;

import com.challenge.forohub.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final IAnswerService iAnswerService;

    @Autowired
    public AnswerController(IAnswerService iAnswerService) {
        this.iAnswerService = iAnswerService;
    }
}
