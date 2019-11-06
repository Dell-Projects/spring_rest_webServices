package com.spring.rest.webservices.restwebservices;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {

    private static List<User> users = new ArrayList<>();
    private int usersCount = 6;

    //Using hardcoded array o users
    static {
        users.add(new User(1, "Fallavena", new Date()));
        users.add(new User(2, "Lipe", new Date()));
        users.add(new User(3, "Ju", new Date()));
        users.add(new User(4, "Sophia", new Date()));
        users.add(new User(5, "Cristofer", new Date()));
        users.add(new User(6, "João", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User userToBeSaved){
        if(userToBeSaved.getId() == null)
            userToBeSaved.setId(++usersCount);

        users.add(userToBeSaved);
        return userToBeSaved;
    }

    public User findById(int id){
        for (User user:users){
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
