package com.challenge.forohub.service;

import com.challenge.forohub.entity.Answer;

import java.util.List;

public interface IAnswerService {
    Answer saveAnswer(Answer answer);

    List<Answer> answers();

    Answer updateAnswer(Answer answer);

    Answer getById(Long id);

    void deleteAnswer(Long id);
}
