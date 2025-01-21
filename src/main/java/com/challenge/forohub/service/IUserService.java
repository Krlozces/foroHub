package com.challenge.forohub.service;

import com.challenge.forohub.entity.User;

import java.util.List;

public interface IUserService {
    User registrar(User user);

    List<User> users();

    User userById(Long id);

    User actualizar(User user);

    void eliminar(Long id);
}
