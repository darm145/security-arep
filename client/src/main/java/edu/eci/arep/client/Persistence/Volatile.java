package edu.eci.arep.client.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.eci.arep.client.Entities.User;

@Component
@Scope("singleton")
public class Volatile implements Connect {
    ArrayList<User> users;
    
    public Volatile(){
        users=new ArrayList<User>();
        User u=new User();
        u.setName("david");
        u.setPassword("password");
        users.add(u);
    }
    @Override
    public User getUserById(String userId) {
        for(User u:users){
            if (u.getName().equals(userId)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        int index=-1;
        for(User u:users){
            if(u.getName().equals(user.getName())){
                index=users.indexOf(u);
                break;
            }
        }
        if(index!=-1){
            users.set(index,user);
            return user;
        }
        return null;

    }

    @Override
    public void removeUser(String userId) {
        User toBeRemoved=null;
        for(User u:users){
            if(u.getName().equals(userId)){
                toBeRemoved=u;
                break;
            }
        }
        if(!toBeRemoved.equals(null)){
            users.remove(toBeRemoved);
        }

    }

    @Override
    public List<User> getUsersList() {
        return users;
    }
}