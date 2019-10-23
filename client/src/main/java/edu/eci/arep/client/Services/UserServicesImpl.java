package edu.eci.arep.client.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arep.client.Entities.User;
import edu.eci.arep.client.Services.UserServices;
import edu.eci.arep.client.Persistence.Connect;


@Component
public class UserServicesImpl implements UserServices {
    @Autowired
    Connect database;

    @Override
    public List<User> getUsersList() {
        return database.getUsersList();
    }

    @Override
    public User getUserById(String userId) {
        return database.getUserById(userId);
    }

    @Override
    public User createUser(User user) {
        return database.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return database.updateUser(user);
    }

    @Override
    public void removeUser(String userId) {
        database.removeUser(userId);
    }

}