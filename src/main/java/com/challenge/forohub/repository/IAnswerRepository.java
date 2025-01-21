package com.challenge.forohub.repository;

import com.challenge.forohub.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long> {
}
