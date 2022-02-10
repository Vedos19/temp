package com.example.demo1.database.impl.jbdc;

import com.example.demo1.database.IUserDAO;
import com.example.demo1.model.User;

import java.util.Optional;

public class UserDAOImpl implements IUserDAO {
    @Override
    public Optional<User> getUserByLogin() {
        return Optional.empty();
    }

    @Override
    public void addUser() {

    }
}
