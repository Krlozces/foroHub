package com.challenge.forohub.controller;

import com.challenge.forohub.entity.Topic;
import com.challenge.forohub.service.ITopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    private final ITopicService iTopicService;

    @Autowired
    public TopicController(ITopicService iTopicService) {
        this.iTopicService = iTopicService;
    }

    @GetMapping
    public ResponseEntity<List<Topic>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(iTopicService.topics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> detalle(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iTopicService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Topic> actualizar(@RequestBody Topic topic) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iTopicService.actualizar(topic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        iTopicService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Topic> guardar(@Valid @RequestBody Topic topic) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iTopicService.guardar(topic));
    }
}
