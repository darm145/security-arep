package edu.eci.arep.client.Persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.arep.client.Entities.User;



@Service
public interface Connect{
    
    List<User> getUsersList();
    
    User getUserById(String userId);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);
    
}