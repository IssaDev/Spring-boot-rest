package com.IssaDev.SpringRest.Rest.services.with.Spring.Controllers;

import com.IssaDev.SpringRest.Rest.services.with.Spring.ExceptionHandlers.UserNotFoundException;
import com.IssaDev.SpringRest.Rest.services.with.Spring.User;
import com.IssaDev.SpringRest.Rest.services.with.Spring.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = service.getUser(id);
        if(user == null){
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addNewUser(@RequestBody User user){
        User newUser = service.addUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
