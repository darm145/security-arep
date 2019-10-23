package edu.eci.arep.client.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arep.client.Entities.User;

@Service
public interface UserServices {
    List<User> getUsersList();
    
    User getUserById(String userId);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);
}