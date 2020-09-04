package com.kude.stu.kudestu.stu.service;

import com.kude.stu.kudestu.stu.dao.UserDao;
import com.kude.stu.kudestu.stu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User pdate(User user) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }


}
