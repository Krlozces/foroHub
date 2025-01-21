package com.challenge.forohub.repository;

import com.challenge.forohub.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByTitleAndMessage(String title, String message);
    boolean existsByTitleAndMessageAndIdNot(String title, String message, Long id);
}
