package com.challenge.forohub.service.impl;

import com.challenge.forohub.entity.Topic;
import com.challenge.forohub.repository.ITopicRepository;
import com.challenge.forohub.repository.IUserRepository;
import com.challenge.forohub.service.ITopicService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements ITopicService {
    private final ITopicRepository iTopicRepository;

    @Autowired
    public TopicServiceImpl(ITopicRepository iTopicRepository) {
        this.iTopicRepository = iTopicRepository;
    }

    @Override
    public Topic guardar(Topic topic) {
        boolean exists = iTopicRepository.existsByTitleAndMessage(topic.getTitle(), topic.getMessage());
        if (exists) {
            throw new IllegalArgumentException("El tópico con el mismo título y mensaje ya existe.");
        }

        return iTopicRepository.save(topic);
    }

    @Override
    public List<Topic> topics() {
        return iTopicRepository.findAll();
    }

    @Override
    public Topic buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID proporcionado no es válido.");
        }
        return iTopicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado con ID: " + id));
    }

    @Override
    public Topic actualizar(Topic topic) {
        if (topic.getId() == null) {
            throw new IllegalArgumentException("El ID del tópico es obligatorio para actualizar.");
        }

        Optional<Topic> existingTopic = iTopicRepository.findById(topic.getId());
        if (!existingTopic.isPresent()) {
            throw new EntityNotFoundException("No se encontró el tópico con ID: " + topic.getId());
        }

        boolean isDuplicate = iTopicRepository.existsByTitleAndMessageAndIdNot(topic.getTitle(), topic.getMessage(), topic.getId());
        if (isDuplicate) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        return iTopicRepository.save(topic);
    }

    @Override
    public void eliminar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del tópico es obligatorio para eliminar.");
        }

        Optional<Topic> existingTopic = iTopicRepository.findById(id);
        if (!existingTopic.isPresent()) {
            throw new EntityNotFoundException("No se encontró el tópico con ID: " + id);
        }

        iTopicRepository.deleteById(id);
    }
}
