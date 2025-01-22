package com.challenge.forohub.service.impl;

import com.challenge.forohub.entity.Answer;
import com.challenge.forohub.repository.IAnswerRepository;
import com.challenge.forohub.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements IAnswerService {
    private final IAnswerRepository iAnswerRepository;

    @Autowired
    public AnswerServiceImpl(IAnswerRepository iAnswerRepository) {
        this.iAnswerRepository = iAnswerRepository;
    }

    @Override
    public Answer saveAnswer(Answer answer) {
        if (answer != null) {
            return iAnswerRepository.save(answer);
        }
        throw new IllegalArgumentException("La respuesta no puede estar vacía.");
    }

    @Override
    public List<Answer> answers() {
        return iAnswerRepository.findAll();
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        if (answer != null && answer.getId() != null) {
            Optional<Answer> existingAnswer = iAnswerRepository.findById(answer.getId());
            if (existingAnswer.isPresent()) {
                Answer updatedAnswer = existingAnswer.get();
                updatedAnswer.setMessage(answer.getMessage());
                updatedAnswer.setTopic(answer.getTopic());
                updatedAnswer.setCreationDate(answer.getCreationDate());
                updatedAnswer.setAuthor(answer.getAuthor());
                updatedAnswer.setSolution(answer.getSolution());
                return iAnswerRepository.save(updatedAnswer);
            } else {
                throw new RuntimeException("La respuesta con el id " + answer.getId() + " no encontrada");
            }
        }
        throw new IllegalArgumentException("Los campos no pueden estar vacíos.");
    }

    @Override
    public Answer getById(Long id) {
        Optional<Answer> answer = iAnswerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        }
        return null;
    }

    @Override
    public void deleteAnswer(Long id) {
        if (iAnswerRepository.existsById(id)) {
            iAnswerRepository.deleteById(id);
        } else {
            throw new RuntimeException("La respuesta con ID" + id + "no fue encontrada.");
        }
    }
}
