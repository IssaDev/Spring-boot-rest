package com.IssaDev.SpringRest.Rest.services.with.Spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> userList = new ArrayList<>();
    private int userId =4040;

    static {
        userList.add(new User(1010,"Brienne of Tart",new Date()));
        userList.add(new User(4040,"Kylian",new Date()));
    }

    public List<User> getUsers(){
        return userList;
    }

    public User addUser(User user){
        System.out.println("init id id " + user.getId());
        if(user.getId() == 0){
            System.out.println("id is 0");
            userId = userId + 1000;
            user.setId(userId);
        }
        userList.add(user);
        return user;
    }
    public User getUser(int id){
        for(User aUser: userList){
            if (aUser.getId() == id){
                return aUser;
            }
        }
        return null;
    }
}
