package com.kude.stu.kudestu.stu.service;

import com.kude.stu.kudestu.stu.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserById(int id);

    User save(User user);

    User pdate(User user);

    void deleteById(int id);

    User login(String username, String password);
}
