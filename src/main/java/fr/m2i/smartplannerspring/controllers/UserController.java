package fr.m2i.smartplannerspring.controllers;


import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(
            path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<User> getUsers(){
        return userService.getUsers();
    }


    @GetMapping(
            path = "/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User getUsers(@PathVariable("id")Integer id){
        return userService.getUserById(id);
    }

    @PostMapping(
            path = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping(
            path = "/delete/{id}"
    )
    public void deleteUserById(@PathVariable("id")Integer id){
        userService.deleteById(id);
    }





}
