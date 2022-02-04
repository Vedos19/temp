package com.example.demo1.database;

import com.example.demo1.model.User;

import java.util.Optional;

public interface IUserDAO {
    public Optional<User> getUserByLogin();

    public void addUser();
}
