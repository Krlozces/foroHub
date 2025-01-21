package com.challenge.forohub.controller;

import com.challenge.forohub.entity.Answer;
import com.challenge.forohub.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final IAnswerService iAnswerService;

    @Autowired
    public AnswerController(IAnswerService iAnswerService) {
        this.iAnswerService = iAnswerService;
    }

    @GetMapping
    public ResponseEntity<List<Answer>> answers() {
        return ResponseEntity.status(HttpStatus.OK).body(iAnswerService.answers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> answerDetails(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iAnswerService.getById(id));
    }

    @PutMapping
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iAnswerService.updateAnswer(answer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        iAnswerService.deleteAnswer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iAnswerService.saveAnswer(answer));
    }
}
