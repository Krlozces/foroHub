package com.challenge.forohub.service;

import com.challenge.forohub.entity.Topic;

import java.util.List;

public interface ITopicService {
    Topic guardar(Topic topic);

    List<Topic> topics();

    Topic buscarPorId(Long id);

    Topic actualizar(Topic topic);

    void eliminar(Long id);
}
